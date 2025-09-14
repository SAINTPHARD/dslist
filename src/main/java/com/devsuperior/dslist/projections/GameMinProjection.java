package com.devsuperior.dslist.projections;

public interface GameMinProjection {

    // Métodos para aceder aos dados da consulta SQL nativa
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
