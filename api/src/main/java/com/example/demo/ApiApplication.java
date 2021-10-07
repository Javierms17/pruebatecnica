package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dao.IClienteDao;
import com.example.demo.entity.Cliente;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.controller"})
public class ApiApplication {
	@Autowired
	public static IClienteDao clienteDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
	
		
		System.out.println("holaaaa");
	}

}
