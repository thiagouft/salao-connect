package com.ps.salaoconnect.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.service.SalaoService;

@RestController   //*Controlador Rest
@RequestMapping(value = "/salao")
public class SalaoResources {
	
	
	
	@Autowired
	private SalaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
	 		
		Salao obj = service.find(id);
	
		return ResponseEntity.ok().body(obj);
	}
		
}
