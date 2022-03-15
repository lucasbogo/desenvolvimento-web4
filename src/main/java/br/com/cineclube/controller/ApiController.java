package br.com.cineclube.controller;

import java.util.Optional;

//import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineclube.dao.FilmeRepository;
import br.com.cineclube.dao.PersonRepository;
import br.com.cineclube.model.Filme;
import br.com.cineclube.model.Person;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private FilmeRepository daoFilme; // injeçao FilmeRepositório,

	@Autowired
	private PersonRepository daoPerson; // injeção do PersonRepository

//FILMES

	/*
	 * optei por usar o optional findById
	 * 
	 * @GetMapping("/filmes/{id}") public Filme getFilme(@PathVariable Long id) {
	 * return daoFilme.getById(id); }
	 */

	//Obter um recurso com optional para tratar cenários onde o recurso não existe
	@GetMapping("/filmes/{id}") // http :8080/api/filmes/29 - FUNCIONA
	Optional<Filme> getFilme(@PathVariable Long id) {
		return daoFilme.findById(id);
	}

	@GetMapping(value = "/filmes") // GET - Uri:localhost:8080/api/filmes - postman - FUNCIONA
	Iterable<Filme> getFilmes() {  // http :8080/api/filmes - httpie.io - FUNCIONA
		return daoFilme.findAll();
	}
    
	//Adicionar recurso
	@PostMapping("/filmes") // POST - Uri: localhost:8080/api/filmes - passar com json na body - postman -
		Filme postFilme(@RequestBody Filme filme) {
		daoFilme.save(filme);
		return filme;
	}

	//Delete filme  
	@DeleteMapping("/filmes/{id}") // http DELETE :8080/api/filmes/29
	void deleteFilme(@PathVariable Long id) {
		daoFilme.deleteById(id);
	}

	//Atualizar recurso
	@PutMapping("/filmes/{id}")
	ResponseEntity<Filme> putPerson(@PathVariable Long id, @RequestBody Filme filme) {
		Filme f = daoFilme.save(filme);
		if (f != null)
			return new ResponseEntity<Filme>(filme, HttpStatus.CREATED);

		return new ResponseEntity<Filme>(filme, HttpStatus.OK);
	}

//PERSON

	/*
	 * Utilizei o optional para buscar por id
	 * 
	 * @GetMapping("/person/{id}") public Person getPerson(@PathVariable Long id) {
	 * return daoPerson.getById(id); }
	 */

	//Método para salvar uma pessoa -FUNCIONA
	@GetMapping("/person/new/{name}")
	public Person newPerson(@PathVariable String name) {
		Person person = new Person(name);
		daoPerson.save(person);
		return person;
	}

	//Obter um recurso com optional para tratar cenários onde o recurso não existe
	@GetMapping("/person/{id}")
	Optional<Person> getPerson(@PathVariable Long id) { // Ver com prof. Nome do get
		return daoPerson.findById(id);
	}

	//Obtem a lista de pessoas
	@GetMapping(value = "/people")
	Iterable<Person> getPeople() {
		return daoPerson.findAll();
	}

	//Adiciona um recurso
	@PostMapping("/person")
	Person postPerson(@RequestBody Person person) {
		daoPerson.save(person);
		return person;
	}

	//Remove um recurso
	@DeleteMapping("/person")
	void deletePerson(@PathVariable Long id) {
		daoPerson.deleteById(id);
	}

	//Atualizar recurso
	@PutMapping("/person/{id}")
	ResponseEntity<Person> putPerson(@PathVariable Long id, @RequestBody Person person) {
		Person p = daoPerson.save(person);
		if (p != null)
			return new ResponseEntity<Person>(person, HttpStatus.CREATED);

		return new ResponseEntity<Person>(person, HttpStatus.OK);

//PUT request deve atualizar se o recurso ja existe, caso contrário, deve criá-lo.			

	}
}
