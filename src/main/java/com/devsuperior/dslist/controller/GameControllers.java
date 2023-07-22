package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value = "/games")

public class GameControllers {

	@Autowired
	private GameService gameService;

	@GetMapping // Rota responsável por buscar todos os dados do banco
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

	@GetMapping("/{id}")
	public List<GameMinDTO> getById(@PathVariable("id") Long id) {
		List<GameMinDTO> game = gameService.findAllById(id);
		return game;
	}

	@GetMapping("/other/{id}")
	public Game findById(@PathVariable("id") Long id) {
		Game game = gameService.findById(id);
		return game;
	}
}
