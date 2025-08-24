package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Embeddable;

public class BelongingPK {

	@ManyToOne // Muitos para um (para mapear o relacionamento entre Game e GameList)
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne // Muitos para um (uma lista pode ter muitos jogos, mas um jogo pertence a uma lista)
	@JoinColumn(name = "list_id")
	private GameList list;
	
	@embeddable 
	public BelongingPK() {
	}
	
	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	// Getters and Setters for all fields
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	// hashCode and equals para comparar objetos pelo ID
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
}
