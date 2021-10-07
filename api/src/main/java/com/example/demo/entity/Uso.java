package com.example.demo.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Uso {

	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Edificio edificio;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Cliente cliente;
	private Date fechaHora;
	
	
	
	public Uso(int id, Edificio edificio, Cliente cliente, Date fechaHora) {
		super();
		this.id = id;
		this.edificio = edificio;
		this.cliente = cliente;
		this.fechaHora = fechaHora;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	
}
