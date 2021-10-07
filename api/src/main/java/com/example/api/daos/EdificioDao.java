package com.example.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.api.entity.Edificio;

public interface EdificioDao extends JpaRepository<Edificio, Integer> {

}
