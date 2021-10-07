package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Edificio {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String Ciudad;
	
	
	
	public Edificio(int id, String ciudad) {
		super();
		this.id = id;
		Ciudad = ciudad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	
	
}
