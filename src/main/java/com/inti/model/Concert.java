package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private LocalDate date;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="idLieu")
	private Lieu lieu;
	

	@OneToMany(mappedBy = "Concert", targetEntity = Oeuvre.class)
	private List<Oeuvre> listeOeuvre;
	
	
	public Concert(LocalDate date, String nom) {
		super();
		this.date = date;
		this.nom = nom;
	}
	
	
}
