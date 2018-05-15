package com.ps.salaoconnect.domain;

import java.io.Serializable;

public class Avaliacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private int nivelSatisfacao;
	
	public Avaliacao() {
	}

	public Avaliacao(Integer id, String descricao, int nivelSatisfacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nivelSatisfacao = nivelSatisfacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNivelSatisfacao() {
		return nivelSatisfacao;
	}

	public void setNivelSatisfacao(int nivelSatisfacao) {
		this.nivelSatisfacao = nivelSatisfacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
