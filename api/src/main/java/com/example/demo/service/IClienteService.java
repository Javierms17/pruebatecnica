package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);
	
}
