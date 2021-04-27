package com.studio.william.cursomc.domain.enums;


public enum TipoCliente {

	PERSONANATURAL(1, "Persona Natural"),
	PERSONAJURIDICA(2, "Persona Juridica");
	
	private int cod;
	private String descripcion; 
	
	private TipoCliente(int cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	public static TipoCliente toEmun(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x: TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id no valido "+ cod);
	}
}
