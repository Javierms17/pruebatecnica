package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Edificio;

public interface IEdificioDao extends JpaRepository<Edificio, Integer> {
	@Query (value = "select p from Edificio p")
	public List<Edificio> findAll();
	
	@Query (value = "select p from Edificio p where p.id = :id")
	public Edificio findbyId(int id);
}
