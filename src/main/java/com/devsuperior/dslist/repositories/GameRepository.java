package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	// Interface GameRepository estende JpaRepository para operações CRUD
	// JpaRepository<Game, Long> indica que a entidade é Game e o tipo da chave primária é Long
	// Não é necessário implementar métodos aqui, pois JpaRepository já fornece os métodos básicos

}
