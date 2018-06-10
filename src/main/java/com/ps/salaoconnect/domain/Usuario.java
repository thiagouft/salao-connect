package com.ps.salaoconnect.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ps.salaoconnect.domain.enums.Perfil;
import com.ps.salaoconnect.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private char sexo;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String senha;
	private Integer tipo;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "usuario")
	private Agendar agendar;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "usuario")
	private List<Salao> salao = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	

	public Usuario(){
	}
	
	public Usuario(Integer id, String nome, char sexo, String email, String senha, TipoUsuario tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.tipo = (tipo==null) ? null : tipo.getCod();
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
	
	public Agendar getAgendar() {
		return agendar;
	}

	public void setAgendar(Agendar agendar) {
		this.agendar = agendar;
	}
	
	public TipoUsuario getTipo() {
		return TipoUsuario.toEnum(tipo);
	}
	
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo.getCod();
	}

	public List<Salao> getSalao() {
		return salao;
	}

	public void setSalao(List<Salao> salao) {
		this.salao = salao;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
