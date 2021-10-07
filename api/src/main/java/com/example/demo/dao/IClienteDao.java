package com.example.demo.dao;

import java.util.List;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cliente;


public interface IClienteDao extends JpaRepository<Cliente, Integer> {

	@Query (value = "select p from Cliente p")
	public List<Cliente> findAll();
	
	@Query (value = "select p from Cliente p where p.id = :id")
	public Cliente findbyId(int id);
	
}
