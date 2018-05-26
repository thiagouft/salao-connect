package com.ps.salaoconnect.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.service.UsuarioService;

@RestController   //*Controlador Rest
@RequestMapping(value = "/usuarios")
public class UsuarioResources {
	
	
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
	 		
		Usuario obj = service.buscar(id);
	
		return ResponseEntity.ok().body(obj);
	}
		
}