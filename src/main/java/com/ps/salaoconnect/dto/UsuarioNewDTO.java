package com.ps.salaoconnect.dto;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ps.salaoconnect.services.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=2, max=50, message="O tamanho deve ser entre 2 e 50 caracteres")
	private String nome;
	private char sexo;
	@NotEmpty
	@Email(message="Email Inválido")
	private String email;
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	@NotEmpty(message="Campo Obrigatório")
	private Integer tipo;
		
	public UsuarioNewDTO() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}	
	
}
