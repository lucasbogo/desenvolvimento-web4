package br.com.cineclube.config.util;

import java.util.Comparator;
import java.util.List;

import br.com.cineclube.model.Movie;

public class WrapperMovieSearch {

	
	
    private List<Movie> results;

    public List<Movie> getResults() {
    	

        // ordem decrescente == ordena por filmes mais populares
		results.sort( new Comparator<Movie>() {
			public int compare(Movie movie1, Movie movie2) {
				return Integer.compare(movie2.getVote_count(), movie1.getVote_count());
			}
		});

		return results;
    }
    
    public void setResults(List<Movie> results) {
        this.results = results;
    }
    
}
