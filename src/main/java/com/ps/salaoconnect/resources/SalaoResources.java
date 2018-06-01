package com.ps.salaoconnect.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.dto.SalaoDTO;
import com.ps.salaoconnect.dto.SalaoNewDTO;
import com.ps.salaoconnect.service.SalaoService;

@RestController   //*Controlador Rest
@RequestMapping(value = "/salao")
public class SalaoResources {
	
	
	
	@Autowired
	private SalaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Salao> find(@PathVariable Integer id) {	 		
		Salao obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SalaoNewDTO objDto){
		Salao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SalaoDTO objDto, @PathVariable Integer id){
		Salao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalaoDTO>> findAll() {
	 	List<Salao> list = service.findAll();
	 	List<SalaoDTO> listDto = list.stream().map(obj -> new SalaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
		public ResponseEntity<Page<SalaoDTO>> findPage(
				@RequestParam (value="page", defaultValue="0") Integer page, 
				@RequestParam (value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam (value="orderBy", defaultValue="nome") String orderBy, 
				@RequestParam (value="direction", defaultValue="ASC") String direction) {		
			Page<Salao> list = service.findPage(page, linesPerPage, orderBy, direction);
			Page<SalaoDTO> listDto = list.map(obj -> new SalaoDTO(obj)); 
			return ResponseEntity.ok().body(listDto);
	}
		
}
