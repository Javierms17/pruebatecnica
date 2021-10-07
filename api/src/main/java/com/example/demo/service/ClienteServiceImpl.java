package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IClienteDao;
import com.example.demo.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
	
		return clienteDao.save(cliente);
	}

}
