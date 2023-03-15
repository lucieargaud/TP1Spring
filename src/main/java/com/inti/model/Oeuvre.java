package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Num;
	private String Nom;
	private int Duree;

	@ManyToMany
	@JoinTable(name = "Oeuvre-Soliste", joinColumns = @JoinColumn(name = "NumOeuvre"), inverseJoinColumns = @JoinColumn(name = "NumSoliste"))
	private List<Soliste> listeSoliste;

	@ManyToOne
	@JoinColumn(name = "NumChefOrchestre")
	private ChefOrchestre ChefO;
	
	@ManyToOne
	@JoinColumn(name = "NumConcert")
	private Concert Concert;
	

}
