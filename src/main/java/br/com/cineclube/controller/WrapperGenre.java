package br.com.cineclube.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cineclube.model.Genre;

public class WrapperGenre {

	private List<Genre> genres;
	
	public List<Genre> getGenres(){
		return genres;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres=genres;
	}
}