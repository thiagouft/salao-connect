package com.ps.salaoconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.repositories.SalaoRepository;

@Service
public class SalaoService {
	
	@Autowired
	private SalaoRepository repo;
	
	public Salao find(Integer id) {
		Optional<Salao> obj = repo.findById(id);
			return obj.orElse(null);
	}

}
