package com.studio.william.cursomc.domain.enums;


public enum EstadoPago {

	PENDIENTE(1, "Pendiente"),
	ESTABLECIDO(2, "Establecido"), 
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descripcion; 
	
	private EstadoPago(int cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	public static EstadoPago toEmun(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (EstadoPago x: EstadoPago.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id no valido "+ cod);
	}
}
