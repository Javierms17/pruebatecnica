package com.example.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
