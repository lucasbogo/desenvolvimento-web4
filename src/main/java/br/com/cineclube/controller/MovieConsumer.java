package br.com.cineclube.controller;

import java.util.HashMap;
import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.cineclube.model.Movie;

@RestController
@RequestMapping("/api/v1")
public class MovieConsumer {

	@Value("${api.moviedb.key}")
	private String apiKey;

	@Autowired
	private RestTemplate apiRequest;

	// find movie by id - FUNCIONA!
	@RequestMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable Long id) {
		String endpoint = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey;

		Movie movie = apiRequest.getForObject(endpoint, Movie.class);

		return movie;
	}

	// NEED TO STUDY THIS FURTHER... THIS IS THE THE TEACHER'S CODE...
	@GetMapping("/search")
	public WrapperMovieSearch searchMovie(@RequestParam String title, @RequestParam String year) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", apiKey);
		params.put("query", title);
		params.put("year", year);
		params.put("lang", "en-US");
		String url = "https://api.themoviedb.org/3/search/movie?api_key={key}&query={query}&year={year}&language={lang}";
		WrapperMovieSearch res = apiRequest.getForObject(url, WrapperMovieSearch.class, params);
		return res;
	}

	// I NEED TO STUDY THIS!  THIS IS ADRIANO'S CODE...
	@GetMapping("/movies/filter")
	public WrapperMovieSearch searchFilter(@RequestParam(required = false) String minDate,
			@RequestParam(required = false) String maxDate, @RequestParam(required = false) String genre) {

		if (minDate.equals("null") || minDate.trim().equals("")) {
			minDate = "1980";
		}
		if (maxDate.equals("null") || maxDate.trim().equals("")) {
			maxDate = "1990";
		}
		if (genre.equals("null") || genre.trim().equals("")) {
			genre = "878";
		}

		
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", apiKey);
		params.put("minDate",minDate);
		params.put("maxDate", maxDate);
		params.put("genre", genre);
		String url = "https://api.themoviedb.org/3/discover/movie?api_key={key}&primary_release_date.gte={minDate}&primary_release_date.lte={maxDate}&with_genres={genre}&sort_by=vote_count.desc";
		WrapperMovieSearch res = apiRequest.getForObject(url, WrapperMovieSearch.class, params);
		return res;
	}

}
