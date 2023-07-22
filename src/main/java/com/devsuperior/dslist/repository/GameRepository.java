package com.devsuperior.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	//Tipo Long é referente ao ID da entidade.
	//Camada de acesso a dados
	//Interface responsável por manipular o objeto dentro do banco. (Criar, alterar e etc)
}
