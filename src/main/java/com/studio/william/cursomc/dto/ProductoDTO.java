package com.studio.william.cursomc.dto;

import java.io.Serializable;

import com.studio.william.cursomc.domain.Producto;

public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private Double precio;

	public ProductoDTO() {

	}
	public ProductoDTO(Producto obj) {
		id = obj.getId();
		nombre = obj.getNombre();
		precio = obj.getPrecio();
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
