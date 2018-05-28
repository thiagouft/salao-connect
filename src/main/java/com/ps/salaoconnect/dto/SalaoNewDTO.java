package com.ps.salaoconnect.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class SalaoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=2, max=50, message="O tamanho deve ser entre 2 e 50 caracteres")
	private String nome;
	private boolean ativo;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nomeProprietario;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String telefone;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String logradouro;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String numero;
	private String complemento;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String bairro;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String cep;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String descricao;
	@NotNull(message="Preenchimento Obrigatório")
	private float valor;
	@NotNull(message="Preenchimento Obrigatório")
	private int tempoGasto;
	
	public SalaoNewDTO() {
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getTempoGasto() {
		return tempoGasto;
	}
	
	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
