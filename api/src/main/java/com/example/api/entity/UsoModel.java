package com.example.api.entity;

public class UsoModel {
	
	private	int idCliente;
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int idEdificio;
	private int maquina;
	
	public int getMaquina() {
		return maquina;
	}
	public void setMaquina(int maquina) {
		this.maquina = maquina;
	}
	public UsoModel() {
		super();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getIdEdificio() {
		return idEdificio;
	}
	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}
	
	
}
