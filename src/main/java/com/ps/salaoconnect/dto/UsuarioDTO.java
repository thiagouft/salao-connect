package com.ps.salaoconnect.dto;

import java.io.Serializable;

import com.ps.salaoconnect.domain.Usuario;
import com.ps.salaoconnect.services.validation.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private char sexo;
	
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		sexo = obj.getSexo();
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

}
