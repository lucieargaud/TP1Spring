package com.inti.controller;


import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;
import com.inti.repository.ILieuRepository;


@Controller
@RequestMapping("concerts")
public class ConcertController {

	
	@Autowired IConcertRepository icr;
	@Autowired ILieuRepository ilr;
	
	@GetMapping("listeConcert")
	public String afficher(Model m) {
		m.addAttribute("listConcert", icr.findAll());
		
		
		
		
		return "concerts";
	}
	@GetMapping("formConcert")
	public String ajouter(Model m) {
		m.addAttribute("listLieu", ilr.findAll().toArray());
		return"formConcert";
		
	}
	@PostMapping("saveConcert")
	public String save(Model m,@RequestParam("date") String date, @RequestParam("nom") String nom, @RequestParam("lieu") int idLieu) {
		
		Concert c = new Concert(LocalDate.parse(date), nom);
		c.setLieu(ilr.findById(idLieu).get());
		icr.save(c);
		m.addAttribute("listConcert",icr.findAll().toArray());
		
		return "concerts";
		
	}
  	@GetMapping("deleteConcert")
	public String deleteConcert(@RequestParam("num") int num) {
		icr.deleteById(num);
		return "redirect:/listeConcert";
	}
	
	@GetMapping("modifierConcert")
	public String modifierConcert(@RequestParam("num") int num, Model m)
	{
		m.addAttribute("concert", icr.findById(num).get());
		return "modifierConcert";
	}
	
	@PostMapping("updateConcert") // Avec une requête Post donc bien =/= du @Get"modifconcert"
	public String updateConcert(@ModelAttribute("concert") Concert c)
	{
		icr.save(c); // = saveOrUpdate
		return "redirect:/listeConcert";
	}
	
	


}
