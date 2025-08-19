package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Classe Game representando a entidade do jogo
@Entity // Anotação para indicar que esta classe é uma entidade JPA(tabela no banco de dados)
@Table(name = "tb_game") // Anotação para definir o nome da tabela no banco de dados

public class Game {

	@Id // Anotação para indicar que o atributo id é a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para indicar que o id será gerado automaticamente pelo banco de dados
	// Attributes da classe Game
	private Long id;
	private String title;
	
	@Column(name = "game_year") // Anotação para definir o nome da coluna no banco de dados
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	// Anotação para definir o tipo da coluna como TEXT no banco de dados
	@Column(columnDefinition = "TEXT") // Anotação para definir o tipo da coluna como TEXT no banco de dados
	private String shortDescription;
	// Anotação para definir o tipo da coluna como TEXT no banco de dados
	@Column(columnDefinition = "TEXT") // Anotação para definir o tipo da coluna como TEXT no banco de dados
	private String longDescription;
	

	public Game() {
	}
	// Constructor with all fields
	public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	// Getters and Setters for all fields
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlatforms() {
		return platforms;
	}
	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	// métodos equals e hashCode para comparar objetos Game pelo id
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	

}
