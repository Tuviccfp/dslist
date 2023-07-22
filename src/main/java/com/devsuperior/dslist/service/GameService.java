package com.devsuperior.dslist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.notfound.NotFoundException;
import com.devsuperior.dslist.repository.GameRepository;

//Componente de serviços do sistema
@Service
public class GameService {

	// Anotação utilizada para fazer uma injeção de dependência. A Interface
	// GameRepository será instânciada na variável gameRepository.
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

	public List<GameMinDTO> findAllById(Long id) {
		List<Game> result = gameRepository.findAllById(java.util.Collections.singletonList(id)); // singletonList() é um
																									// método da classe
																									// Collections.
																									// Retorna uma lista
																									// imutável com base
																									// em um id por
																									// exemplo.
		if (result.isEmpty()) {
			throw new NotFoundException("Não foi possível encontrar o dado.");
		}
		return result.stream()
				.map(GameMinDTO::new)
				.collect(Collectors.toList());
	}

	public Game findById(Long id) {
		Game gameId = gameRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não foi possível encontrar o dado"));
		return gameId;
	}
}
