package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.ChefOrchestre;

import com.inti.repository.IChefORepository;

@Controller
public class ChefOrchestreController {
	@Autowired
	IChefORepository icr;
	
	@GetMapping("formChefO")
	public String formChefO() {
		return "formChefO";
	}

	@PostMapping("saveChefO")
	public String saveChefO(@ModelAttribute("chef") ChefOrchestre c) {
		icr.save(c);
		return "redirect:/listeChefO";
	}

	@GetMapping("listeChefO")
	public String listeChefO(Model m) {
		m.addAttribute("listeChefO", icr.findAll());
		return "listeChefO";
	}
	@GetMapping("getChefOrchestre")
	public String getChefOrchestre(@RequestParam("id") int id, Model m) {
		m.addAttribute("Chef", icr.findById(id).get());
		return "getChefOrchestre";
	}
	@GetMapping("deleteChefO")
	public String deleteChefO(@RequestParam("id") int id) {
		icr.deleteById(id);
		return "redirect:/listeChefO";
	}
	
	@GetMapping("modifierChefO")
	public String modifierChefO(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("chef", icr.findById(id).get());
		return "modifierChefO";
	}
	
	@PostMapping("updateChefO") 
	public String updateChefO(@ModelAttribute("chef") ChefOrchestre c)
	{
		icr.save(c); 
		return "redirect:/listeChefO";
	}

}
