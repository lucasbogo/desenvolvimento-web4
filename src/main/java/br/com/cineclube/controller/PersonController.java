package br.com.cineclube.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cineclube.dao.PersonRepository;
import br.com.cineclube.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository dao;

	@PostMapping("/save") // salvar pessoa - FUNCIONA!
	public String save(@Valid Person person, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// voltar para a manter.html
			return "person/manter.html";
		}
		dao.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping("/new") // cadastro da pessoa - FUNCIONA!
	public String newForm(Model model) {
		// objeto filme sera mapeado ao ${person} da view
		Person person = new Person();
		model.addAttribute("person", person);

		return "person/manter.html";
	}

	@RequestMapping("/delete/{id}") // remove pessoa - FUNCIONA!
	public String delete(Model model, @PathVariable Long id) {
		dao.deleteById(id);
		return "redirect:/person/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Person> personList = dao.findAll();
		model.addAttribute("personList", personList);
		return "person/list.html";
	}

}
