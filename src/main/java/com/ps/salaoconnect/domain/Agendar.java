package com.ps.salaoconnect.domain;

import java.io.Serializable;
import java.util.Date;

public class Agendar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataHora;
	private String statusAgendamento;
	private String formaDePagamento;
	
	public Agendar() {
	}
	
	public Agendar(Integer id, Date dataHora, String statusAgendamento, String formaDePagamento) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.statusAgendamento = statusAgendamento;
		this.formaDePagamento = formaDePagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
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
		Agendar other = (Agendar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
