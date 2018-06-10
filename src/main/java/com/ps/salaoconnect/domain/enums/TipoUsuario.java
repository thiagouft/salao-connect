package com.ps.salaoconnect.domain.enums;

public enum TipoUsuario {
	
	USUARIONORMAL(1,"Usuario Geral"),
	USUARIOSALAO(2,"Usuario dono de Salao");
	
	private int cod;
	private String descricao;
	
	//Construtor do tipo enumerado ele é sempre do tipo privado.
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		
		if(cod == null)
			return null;
		
		for(TipoUsuario x: TipoUsuario.values()) {
			if(cod.equals(x.getCod())) 
				return x;
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
