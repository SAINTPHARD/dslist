package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Anotação para indicar que esta classe é uma entidade JPA (tabela no banco de dados)
// configuração da tabela de associação entre Game e GameList
@Entity
@Table(name = "tb_belonging")
// classe de associação entre Game e GameList
public class Belonging {

	@EmbeddedId // Indica que é uma chave primária composta
	private BelongingPK id = new BelongingPK(); // Composição: instância de BelongingPK
	
	private Integer position; 
	
	// Construtor sem argumentos
	public Belonging() {
	}
	
	// Construtor com argumentos
	//public Belonging(BelongingPK id, Integer position) {
	//	this.id = id;
	//	this.position = position;
	//}
	
	public Belonging(Game game, GameList list, Integer position) {
		this.id = new BelongingPK(); // Inicializa o id
		
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}
	
	// Getters and Setters for all fields
	public BelongingPK getId() {
		return id;
	}
	public void setId(BelongingPK id) {
		this.id = id;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	// hashCode and equals para comparar objetos pelo ID e posição
	@Override
	public int hashCode() {
		return Objects.hash(id, position);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id) && Objects.equals(position, other.position);
	}
	
	
}
