package com.ps.salaoconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.repositories.SalaoRepository;
import com.ps.salaoconnect.services.exception.DataIntegrityException;
import com.ps.salaoconnect.services.exception.ObjectNotFoundException;

@Service
public class SalaoService {
	
	@Autowired
	private SalaoRepository repo;
	
	public Salao find(Integer id) {
		Optional<Salao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Salao.class.getName()));
	}
	
	public Salao insert(Salao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Salao update(Salao obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);		
		try {
				repo.deleteById(id);
			}
			catch(DataIntegrityViolationException e){
				throw new DataIntegrityException("Não é possível excluir uma Salão que possui Agendamentos");
			}
	}

	public List<Salao> findAll(){
		return repo.findAll();
	}

}
