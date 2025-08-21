package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // Anotação para indicar que esta injetando a classe como um serviço Spring
		// A classe GameService é responsável por implementar a lógica de negócios relacionada aos jogos
public class GameService {
	
	@Autowired // Anotação para injetar a dependência do GameRepository
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll(); // Chamando o método findAll do repositório para buscar todos os jogos no banco de dados
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Convertendo a lista de Game entities para uma lista de GameMinDTOs
		return dto; // Retornando a lista de GameMinDTOs
	}

}


// EXPLICAÇÃO:

// List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); ===> Aqui está sendo utilizado o Stream API do Java para transformar uma lista de entidades Game em uma lista de objetos GameMinDTO.
// O método stream() cria um fluxo de dados a partir da lista result. Em seguida, o método map() é usado para aplicar uma função a cada elemento do fluxo. A função x -> new GameMinDTO(x) cria um novo objeto GameMinDTO para cada entidade Game x. Finalmente, o método toList() coleta os resultados em uma nova lista de GameMinDTOs, que é atribuída à variável dto.

// 