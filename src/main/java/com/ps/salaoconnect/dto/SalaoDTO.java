package com.ps.salaoconnect.dto;

import java.io.Serializable;

import com.ps.salaoconnect.domain.Salao;

public class SalaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String nomeProprietario;
	
	public SalaoDTO() {
	}
	
	public SalaoDTO(Salao obj) {
		id = obj.getId();
		nome = obj.getNome();
		nomeProprietario = obj.getNomeProprietario();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	
}
