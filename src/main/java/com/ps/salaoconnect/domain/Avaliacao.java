package com.ps.salaoconnect.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Avaliacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private int nivelSatisfacao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="agendar_id")
	@MapsId //garatir que seja o mesmo Id do pedido
	private Agendar agendar;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="servico_id")
	private Servicos servico;
	
	
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
	
	public Agendar getAgendar() {
		return agendar;
	}

	public void setAgendar(Agendar agendar) {
		this.agendar = agendar;
	}

	public Servicos getServico() {
		return servico;
	}

	public void setServico(Servicos servico) {
		this.servico = servico;
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
