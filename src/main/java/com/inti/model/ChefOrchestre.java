package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table

public class ChefOrchestre {
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	private double prix;
	private String commentaires;
}
