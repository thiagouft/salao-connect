package com.ps.salaoconnect.dto;

import java.io.Serializable;

import com.ps.salaoconnect.domain.Salao;

public class SalaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String nomeProprietario;
	private boolean ativo;
	private String telefone;
	
	public SalaoDTO() {
	}
	
	public SalaoDTO(Salao obj) {
		id = obj.getId();
		nome = obj.getNome();
		nomeProprietario = obj.getNomeProprietario();
		ativo = obj.isAtivo();
		telefone = obj.getTelefone();
	}	
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
