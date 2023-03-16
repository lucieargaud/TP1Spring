package com.inti.model;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	
	@ManyToMany(mappedBy = "listeSoliste")
private List<Oeuvre> listeOeuvre;
	

}
