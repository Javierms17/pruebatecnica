package com.example.demo.entity;

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
public class Cliente {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private Boolean tarjetaEntregada;
	private int numeroTarjeta;
	private int apartamento;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Edificio edificio;
	
	
	
	public Cliente(int id, String nombre, Boolean tarjetaEntregada, int numeroTarjeta, int apartamento,
			Edificio edificio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tarjetaEntregada = tarjetaEntregada;
		this.numeroTarjeta = numeroTarjeta;
		this.apartamento = apartamento;
		this.edificio = edificio;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getTarjetaEntregada() {
		return tarjetaEntregada;
	}
	public void setTarjetaEntregada(Boolean tarjetaEntregada) {
		this.tarjetaEntregada = tarjetaEntregada;
	}
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public int getApartamento() {
		return apartamento;
	}
	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
}
