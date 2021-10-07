package com.exapmple.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IClienteDao;
import com.example.demo.entity.Cliente;
import com.example.demo.service.IClienteService;

@RestController
@RequestMapping(value = "/cliente")
//localhost:8080/cliente
public class clienteController {
	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		System.out.println("entre aca");
		return ResponseEntity.ok(clienteService.findAll());
	}

}
