package com.ps.salaoconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ps.salaoconnect.domain.Endereco;
import com.ps.salaoconnect.domain.Salao;
import com.ps.salaoconnect.domain.Servicos;
import com.ps.salaoconnect.dto.SalaoDTO;
import com.ps.salaoconnect.dto.SalaoNewDTO;
import com.ps.salaoconnect.repositories.EnderecoRepository;
import com.ps.salaoconnect.repositories.SalaoRepository;
import com.ps.salaoconnect.services.exception.DataIntegrityException;
import com.ps.salaoconnect.services.exception.ObjectNotFoundException;

@Service
public class SalaoService {
	
	@Autowired
	private SalaoRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Salao find(Integer id) {
		Optional<Salao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Salao.class.getName()));
	}
	
	public Salao insert(Salao obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Salao update(Salao obj) {
		Salao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);		
		try {
				repo.deleteById(id);
			}
			catch(DataIntegrityViolationException e){
				throw new DataIntegrityException("Não é possível excluir uma Salão que possui Agendamentos de Clientes");
			}
	}

	public List<Salao> findAll(){
		return repo.findAll();
	}
	
	public Page<Salao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
	}
	
	public Salao fromDTO(SalaoDTO objDto) {
		return new Salao(null, objDto.getNome(), objDto.isAtivo(), objDto.getNomeProprietario(), objDto.getTelefone(), null);
	}
	
	public Salao fromDTO(SalaoNewDTO objDto) {
		Salao sal = new Salao(null, objDto.getNome(), objDto.isAtivo(), objDto.getNomeProprietario(), objDto.getTelefone(), objDto.getUsuario());
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), sal);
		Servicos serv = new Servicos(null, objDto.getDescricao(), objDto.getValor(), objDto.getTempoGasto(), sal);
		sal.getEnderecos().add(end);
		sal.getServicos().add(serv);
		return sal;
	}
	
	private void updateData(Salao newObj, Salao obj) {
		newObj.setNome(obj.getNome());
		newObj.setAtivo(obj.isAtivo());
		newObj.setTelefone(obj.getTelefone());
		newObj.setNomeProprietario(obj.getNomeProprietario());
		
	}

}
