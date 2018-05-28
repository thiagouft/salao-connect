package com.ps.salaoconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.repositories.UsuarioRepository;
import com.ps.salaoconnect.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
				
	}
	
	public Usuario insert(Usuario obj) {
			obj.setId(null);
			return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
			find(obj.getId());
			return repo.save(obj);
	}
	
	public void delete(Integer id) {
			find(id);			
			repo.deleteById(id);
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

}
