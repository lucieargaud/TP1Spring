package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	public Concert(LocalDate date, String nom) {
		super();
		this.date = date;
		this.nom = nom;
	}
	
	
}
