package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Edificio;
import com.example.demo.entity.Uso;

public interface IUsoDao extends JpaRepository<Uso, Integer> {
	@Query (value = "select p from Edificio p")
	public List<Uso> findAll();
	
	@Query (value = "select p from Edificio p where p.id = :id")
	public Uso findbyId(int id);
}
