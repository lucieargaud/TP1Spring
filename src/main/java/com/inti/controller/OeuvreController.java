package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

@Controller
public class OeuvreController {
	
	@Autowired
	IOeuvreRepository ior;
	
	@GetMapping("formOeuvre")
	public String formOeuvre() {
		return "formOeuvre";
	}

	@PostMapping("saveOeuvre")
	public String saveOeuvre(@ModelAttribute("oeuvre") Oeuvre o) {
		ior.save(o);
		return "redirect:/listeOeuvre";
	}

	@GetMapping("listeOeuvre")
	public String listeOeuvre(Model m) {
		m.addAttribute("listeOeuvre", ior.findAll());
		return "listeOeuvre";
	}
	@GetMapping("getOeuvre")
	public String getOeuvre(@RequestParam("id") int id, Model m) {
		m.addAttribute("oeuvre", ior.findById(id).get());
		return "getOeuvre";
	}
	@GetMapping("deleteOeuvre")
	public String deleteOeuvre(@RequestParam("id") int id) {
		ior.deleteById(id);
		return "redirect:/listeOeuvre";
	}
	
	@GetMapping("modifierOeuvre")
	public String modifierOeuvre(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("oeuvre", ior.findById(id).get());
		return "modifierOeuvre";
	}
	
	@PostMapping("updateOeuvre")
	public String updateOeuvre(@ModelAttribute("oeuvre") Oeuvre s)
	{
		ior.save(s);
		return "redirect:/listeOeuvre";
	}
}
