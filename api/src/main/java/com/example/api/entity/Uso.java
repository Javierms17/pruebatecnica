package com.example.api.entity;

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
	
	private int hora;
	private int dia;
	private int mes;
	private int anio;
	private int maquina;
	
	public int getMaquina() {
		return maquina;
	}
	public void setMaquina(int maquina) {
		this.maquina = maquina;
	}
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Cliente cliente;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Edificio edificio;
	
	
	
	public Uso() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
	
	
}
