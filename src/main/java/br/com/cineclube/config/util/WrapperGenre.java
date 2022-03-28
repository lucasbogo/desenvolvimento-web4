package br.com.cineclube.config.util;

import java.util.List;
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