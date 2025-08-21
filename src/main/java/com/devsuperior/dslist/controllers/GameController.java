package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games") // Definindo o endpoint /games para acessar os recursos relacionados aos jogos
public class GameController {

	// Injetando a dependência do GameService para acessar os métodos de negócio relacionados aos jogos
	@Autowired
	private GameService gameService;
	
	//@RequestMapping 										// Mapeando o método findAll para o endpoint /games
	//public GameMinDTO findById() {
		//List<GameMinDTO> result = gameService.findAll(); 	// Chamando o método findAll do GameService para buscar todos os jogos
		//return (GameMinDTO) result; 						// Retornando a lista de GameMinDTOs
	//}
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
