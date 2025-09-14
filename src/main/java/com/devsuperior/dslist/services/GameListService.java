package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

// Anotação que define esta classe como um componente de serviço do Spring
@Service
public class GameListService {

	// Injeta a dependência do GameListRepository
	@Autowired
	private GameListRepository gameListRepository;
	
	// Injeta a dependência do GameRepository, necessária para o método move
	@Autowired
	private GameRepository gameRepository;
	
	// Método para buscar todas as listas de jogos.
	// @Transactional(readOnly = true) otimiza a consulta por ser apenas de leitura.
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		// Converte a lista de entidades GameList para uma lista de GameListDTO
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
		// Método para mover um jogo de uma posição para outra dentro de uma lista.
	// @Transactional garante que todas as operações no banco de dados sejam executadas
	// como uma única transação (ou tudo funciona, ou nada é alterado).
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		// 1. Busca no banco todos os jogos da lista especificada
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		// 2. Remove o jogo da sua posição original na memória
		GameMinProjection obj = list.remove(sourceIndex);
		// 3. Adiciona o jogo na sua nova posição na memória
		list.add(destinationIndex, obj);
		
		// 4. Determina o intervalo de posições que precisam ser atualizadas no banco
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		// 5. Percorre o intervalo afetado e atualiza a posição de cada jogo no banco de dados
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
