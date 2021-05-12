package com.studio.william.cursomc.dto;

import java.io.Serializable;

import com.studio.william.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{

	

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	public CategoriaDTO() {
		
	}
	
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nombre = obj.getNombre();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
