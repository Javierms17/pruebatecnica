package com.example.api.rest;


import java.time.Month;
import java.time.Year;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.daos.ClienteDao;
import com.example.api.daos.EdificioDao;
import com.example.api.daos.UsoDao;
import com.example.api.entity.Cliente;
import com.example.api.entity.Edificio;
import com.example.api.entity.TotalAPagarModel;
import com.example.api.entity.Uso;
import com.example.api.entity.UsoModel;

@RestController
@RequestMapping("/")
public class ClientRest {
	
	@Autowired
	private ClienteDao clientDao;
	
	@Autowired
	private EdificioDao edificioDao;
	
	@Autowired
	private UsoDao usoDao;
	
	//@GetMapping//localhost:8080
	@RequestMapping(value = "clientes", method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clientDao.findAll();
		for (Cliente cliente : clientes) {
		System.out.println(cliente.getNombre());
		}
		return ResponseEntity.ok(clientes);
	}
	@RequestMapping(value = "entregatarjeta",method = RequestMethod.POST)
	public ResponseEntity<String> entregaTarjeta(@RequestParam int idCliente,@RequestParam int numeroTarjeta ){
		Cliente c= clientDao.getById(idCliente);
		if(c!=null) {
			if( c.getTarjetaEntregada()==false) {
				c.setNumeroTarjeta(numeroTarjeta);
				c.setTarjetaEntregada(true);
				clientDao.save(c);
				return ResponseEntity.ok("se registro la entrega de la tarjeta");
			}else {
				return ResponseEntity.ok("el usuario ya posee tarjeta");
			}
			
		}else {
			return ResponseEntity.ok("no existe el cliente");
		}
		
		
		
	}
	//POST localhost:8080/registrosdeuso
	@RequestMapping(value = "registrosdeuso",method = RequestMethod.POST)
	public ResponseEntity<String> entregaTarjeta(@RequestBody List<UsoModel> usos){
		if(usos !=null) {
			for (UsoModel usoModel : usos) {
			
				
				Edificio e= edificioDao.getById(usoModel.getIdEdificio());
				if (!edificioDao.existsById(usoModel.getIdEdificio())) {
				
					return ResponseEntity.ok("no existe el edificio con id"+usoModel.getIdEdificio());
				}
			
				Cliente c= clientDao.getById(usoModel.getIdCliente());
				if (!clientDao.existsById(usoModel.getIdCliente())) {
				return	ResponseEntity.ok("no existe el cliente con id"+usoModel.getIdCliente());
				}
				
				System.out.println("se registra el uso para clienteid :"+c.getId());
				Uso u =new Uso();
				u.setAnio(usoModel.getAnio());
				u.setDia(usoModel.getDia());
				u.setHora(usoModel.getHora());
				u.setMes(usoModel.getMes());;
				u.setCliente(c);
				u.setEdificio(e);
				u.setMaquina(usoModel.getMaquina());
				usoDao.save(u);
		
			}
			return ResponseEntity.ok("registro exitoso");
		}else {
			return	ResponseEntity.ok("hubo un error en los registros de uso");
		}
	

	}
	//este webservice es solo para ver como enviar los "usosModel"
	@RequestMapping(value = "usomodel",method = RequestMethod.GET)
	public ResponseEntity<List<UsoModel>> usoModel(){
		UsoModel u1 =new UsoModel();
		u1.setAnio(1);
		u1.setDia(5);
		u1.setHora(6);
		u1.setIdCliente(1);
		u1.setIdEdificio(3);
		u1.setMes(3);
		
		UsoModel u2= new UsoModel();
		u2.setAnio(2);
		u2.setDia(2);
		u2.setHora(2);
		u2.setIdCliente(2);
		u2.setIdEdificio(4);
		u2.setMes(4);
		
		List<UsoModel> usosModel = Arrays.asList(u1,u2 );
		
		return ResponseEntity.ok(usosModel);

	}
	@RequestMapping(value = "usosmesanterior",method = RequestMethod.GET)
	public ResponseEntity<List<UsoModel>> usosMesAnterior(){
		
		Month mes = LocalDate.now().getMonth();
		int anio = LocalDate.now().getYear();
		List<Uso> usos= usoDao.findAll();
		List<UsoModel> usosMesAnterior = new ArrayList<>();
		
		for (Uso uso : usos) {
		
			if (uso.getMes()==mes.getValue()-1 && uso.getAnio() == anio) {
				UsoModel um=new UsoModel();
				um.setAnio(uso.getAnio());
				um.setMes(uso.getMes());
				um.setDia(uso.getDia());
				um.setHora(uso.getHora());
				um.setIdCliente(uso.getCliente().getId());
				um.setIdEdificio(uso.getEdificio().getId());
				usosMesAnterior.add(um);
				
			}
	
		}
	
	return ResponseEntity.ok(usosMesAnterior);
	}
	
	@RequestMapping(value = "totalapagar",method = RequestMethod.GET)
	public ResponseEntity<List<TotalAPagarModel>> totalAPagar(){
		
		Month mes = LocalDate.now().getMonth();
		int anio = LocalDate.now().getYear();
		List<Uso> usos= usoDao.findAll();
		List<Uso> usosMesAnterior = new ArrayList<>();
		
		
		for (Uso uso : usos) {
			if (uso.getMes()==mes.getValue()-1 && uso.getAnio() == anio) {
				usosMesAnterior.add(uso);
			}
			
		}
		List<Cliente> clientes= clientDao.findAll();
		List<TotalAPagarModel> totales= new ArrayList<>();
		for (Cliente cliente : clientes) {
			TotalAPagarModel totalAPagarModel= new TotalAPagarModel();
			totalAPagarModel.setClienteId(cliente.getId());
			float pagar=0;
			for (Uso usoM : usosMesAnterior) {
				System.out.println("mes usomesanterior: "+usoM.getMes());
				System.out.println("usoM.getCliente().getId() "+usoM.getCliente().getId());
				System.out.println("cliente.getId()");
				if(usoM.getCliente().getId()==cliente.getId()) {
					pagar+=100;
				}
			}
			totalAPagarModel.setTotalAPagar(pagar);
			totales.add(totalAPagarModel);
		}
	
	return ResponseEntity.ok(totales);
	}
	

}
