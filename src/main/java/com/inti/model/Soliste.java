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
	private int Num;
	private String Nom;
	private String Prenom;
	private LocalDate DateNaissance;
	private String Nationalité;
	
	@ManyToMany
	@JoinTable(name="oeuvre-soliste", 
			joinColumns = @JoinColumn(name = "NumSoliste"),
			inverseJoinColumns = @JoinColumn(name = "NumOeuvre"))
private List<Oeuvre> listeOeuvre;
	

}
