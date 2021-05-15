package com.studio.william.cursomc.dto;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre; 
	private String email;
	private String numeroDocumento; 
	private Integer tipo;
	
	private String barrio;
	private String codigoPostal;
	private String complemento;
	private String calle;
	private String numero;
	
	
	private String Telefono1;
	private String Telefono2;
	private String Telefono3;
	
	private Integer cuidadId;
	
	public ClienteNewDTO () {}

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

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefono1() {
		return Telefono1;
	}

	public void setTelefono1(String telefono1) {
		Telefono1 = telefono1;
	}

	public String getTelefono2() {
		return Telefono2;
	}

	public void setTelefono2(String telefono2) {
		Telefono2 = telefono2;
	}

	public String getTelefono3() {
		return Telefono3;
	}

	public void setTelefono3(String telefono3) {
		Telefono3 = telefono3;
	}

	public Integer getCuidadId() {
		return cuidadId;
	}

	public void setCuidadId(Integer cuidadId) {
		this.cuidadId = cuidadId;
	}
	
	
	
}
