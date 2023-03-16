package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;

@Controller
public class ConcertController {
	@Autowired
	IConcertRepository icor;
	
	@GetMapping("formConcert")
	public String formConcert() {
		return "formConcert";
	}

	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("concert") Concert c) {
		icor.save(c);
		return "redirect:/listeConcert";
	}

	@GetMapping("listeConcert")
	public String listeConcert(Model m) {
		m.addAttribute("listeConcert", icor.findAll());
		return "listeConcert";
	}
	@GetMapping("getConcert")
	public String getConcert(@RequestParam("num") int num, Model m) {
		m.addAttribute("concert", icor.findById(num).get());
		return "getConcert";
	}
	@GetMapping("deleteConcert")
	public String deleteConcert(@RequestParam("num") int num) {
		icor.deleteById(num);
		return "redirect:/listeConcert";
	}
	
	@GetMapping("modifierConcert")
	public String modifierConcert(@RequestParam("num") int num, Model m)
	{
		m.addAttribute("concert", icor.findById(num).get());
		return "modifierConcert";
	}
	
	@PostMapping("updateConcert") // Avec une requête Post donc bien =/= du @Get"modifconcert"
	public String updateConcert(@ModelAttribute("concert") Concert c)
	{
		icor.save(c); // = saveOrUpdate
		return "redirect:/listeConcert";
	}

}
