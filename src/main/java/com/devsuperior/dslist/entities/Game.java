package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ORM - Mapeamento do Objeto Relacional 
@Entity //Configura a classe java para ser equivalente a uma tabela do banco relacional
@Table(name = "tb_game") //Gera um nome pra tabela
public class Game {
//Classe (objeto) que representa um jogo
	
	@Id //Configura o Id como sendo chave primária da tabela.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gera um valor incrementável para o ID.
	private Long id;
	private String title;
	@Column(name = "game_year") //Customizo o nome de uma coluna na tabela. (Essa configuração é necessária porque ao criar o banco, a palavra year geraria conflito.
	private Integer year;
	private String genre;
	private String platform;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public Game() {
		
	}

	public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl,
			String shortDescription, String longDescription) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platform = platform;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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

//	Classe responsável por comparar se dois objetos são iguais, com base no hashCode calculado (o valor a ser calculado é passado entre parenteses)
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
