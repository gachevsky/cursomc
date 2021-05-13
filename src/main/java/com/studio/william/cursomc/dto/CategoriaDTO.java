package com.studio.william.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import com.studio.william.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{

	

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Llenado obligatorio")
	@Length(min=5, max=80, message= "El tamaño debe ser entre 5 y 80 caracteres")
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
