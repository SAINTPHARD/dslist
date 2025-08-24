package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Mapeamento da entidade GameList (lista de jogos)
@Entity
@Table(name = "tb_game_list")
public class GameList {

	@Id // Anotação para indicar que o atributo id é a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para indicar que o id será gerado automaticamente pelo banco de dados
	private Long id;
	private String name;
	
	public GameList() {
	}
	
	// Constructor with arguments
	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters and Setters for all fields
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// hashCode and equals para comparar objetos pelo ID

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
	
}
