package br.com.cineclube.controller;

//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cineclube.dao.FilmeRepository;
import br.com.cineclube.model.Category;
import br.com.cineclube.model.Filme;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeRepository dao; //private Object filme;

	
	@PostMapping("/save")
	public String save(@Valid Filme filme, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// voltar para a manter.html
			model.addAttribute("categories", Category.values());
			return "filmes/manter.html";
		}
		dao.save(filme);
		return "redirect:/filmes/list";
	}

	@RequestMapping("/new") // cadastro do filme
	public String newForm(Model model) {
		// objeto filme sera mapeado ao ${filme} da view
		Filme filme = new Filme();
		model.addAttribute("filme", filme);

		// criar um lista de categorias
		model.addAttribute("categories", Category.values());

		return "filmes/manter.html";
	}

	@RequestMapping("/delete/{id}") // remove o filme; FUNCIONA
	public String delete(Model model, @PathVariable Long id) {
		dao.deleteById(id);
		return "redirect:/filmes/list";
	}

	// Editar filme: refactor code to receive @PutMapping ro properly edit atribute
	@GetMapping("/update/{id}") // Editar filme; FUNCIONA
	public String update(Model model, @PathVariable Long id) {
		
		Filme filme = dao.findById(id).get();
		model.addAttribute("filme", filme); 
		
		// criar lista de categorias
		model.addAttribute("categories", Category.values());
		return "filmes/manter.html";
	}

	
	/*
	// Editar filme:
	@PutMapping("/update/{id}")
	public String update(@Valid Filme filme, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "filmes/manter.html";
		}
		else {
		return "redirect:/filmes/manter.html";

		} 
	} */

	@RequestMapping("/list")
	public String list(Model model) {
		List<Filme> filmeList = dao.findAll();
		model.addAttribute("filmeList", filmeList);
		return "filmes/list.html";
	}

}