package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

// Anotação que define esta classe como um componente de serviço do Spring
@Service
public class GameService {

	// Injeta a dependência do GameRepository para aceder aos dados dos jogos
	@Autowired
	private GameRepository gameRepository;
	
	// Método para buscar todos os jogos e retornar uma lista simplificada (DTO)
	// @Transactional(readOnly = true) otimiza a consulta por ser apenas de leitura.
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		// Converte a lista de entidades Game para uma lista de GameMinDTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	// Método para buscar um jogo específico por ID e retornar os seus detalhes completos (DTO)
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		// O método .get() é usado para obter o objeto Game de dentro do Optional.
		// Se o id não existir, ele lançará uma exceção.
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
}
