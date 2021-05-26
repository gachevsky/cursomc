package com.studio.william.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "El nombre es Obligatorio")
	@Length(min=5, max=120, message = "El tamaño debe estar entre 5 y 120 caracteres")
	private String nombre;
	
	@NotEmpty(message = "El nombre es Obligatorio")
	@Email(message = "Email no valido")
	private String email;
	public ClienteDTO() {
	
	}
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nombre = obj.getNombre();
		email = obj.getEmail();	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	

}
