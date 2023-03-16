package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;

@Controller
@RequestMapping("lieu")
public class LieuController {
	@Autowired
	ILieuRepository ilr;
	
	
	@GetMapping("ajouter")
	public String add() {
		
		return "formLieu";
	}

	@PostMapping("ajouter")
	public String save(@ModelAttribute(name = "lieu") Lieu lieu) {
		
		System.out.println(lieu);
		ilr.save(lieu);
		return "formLieu";
		
	}
}
