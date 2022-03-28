package br.com.cineclube.controller;

//mport java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.cineclube.model.PersonTMDB;

@RestController
@RequestMapping("/api/v2")
public class PersonTMDBConsumer {

	@Value("${api.moviedb.key}")
	private String apiKey;

	@Autowired
	private RestTemplate apiRequest;

	// apiRequest método getById - FUNCIONA!
	@RequestMapping("/person/{person_id}")
	public PersonTMDB getPersonTMDBById(@PathVariable Long person_id) {
		String endpoint = "https://api.themoviedb.org/3/person/" + person_id + "?api_key=" + apiKey;

		PersonTMDB personTMDB = apiRequest.getForObject(endpoint, PersonTMDB.class);

		return personTMDB;
	}
	
	/*
	// NEEDS WORK.. - NÃO FUNCIONA!
	@GetMapping("/person/search/{name}")
	public WrapperPersonTMDBSearch searchPersonTMDB(@RequestParam String name) {
		Map<String, String> params = new HashMap<>();
		params.put("key", apiKey);
		params.put("query", name);
		params.put("lang", "en-US");
		String url = "https://api.themoviedb.org/3/search/search-people?api_key={key}&query={name}&language={lang}";
		WrapperPersonTMDBSearch result = apiRequest.getForObject(url, WrapperPersonTMDBSearch.class, params);
		return result;
	}
	*/

	/*
	@GetMapping("/person")
	public Optional<PersonTMDB> searchByName(@RequestParam String name) {
		Map<String, String> params = new HashMap<>();
		params.put("key", apiKey);
		params.put("query", name);
		params.put("lang", "en-US");
		String url = "https://api.themoviedb.org/3/search/movie?api_key={key}&query={name}&language={lang}";
		WrapperPersonTMDBSearch result = apiRequest.getForObject(url, WrapperPersonTMDBSearch.class, params);

		PersonTMDB personTMDB = null;
		if (result.getResults() != null && result.getResults().size() > 0)
			personTMDB = result.getResults().get(0);
		return Optional.ofNullable(personTMDB);
	}
	*/

}
