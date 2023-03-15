package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code;
	private String nom;
	private String adr;
	private int nbrFauteuil;
	
	public Lieu(String code, String nom, String adr, int nbrFauteuil) {
		super();
		this.code = code;
		this.nom = nom;
		this.adr = adr;
		this.nbrFauteuil = nbrFauteuil;
	}
	
	
}
