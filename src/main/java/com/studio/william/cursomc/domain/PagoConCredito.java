package com.studio.william.cursomc.domain;

import javax.persistence.Entity;

import com.studio.william.cursomc.domain.enums.EstadoPago;

@Entity
public class PagoConCredito extends Pago{

	private static final long serialVersionUID = 1L;
	private Integer numeroCuotas;

	public PagoConCredito() {
	}

	public PagoConCredito(Integer id, EstadoPago estado, Pedido pedido, Direccion direccionDeEntrega, Integer numeroCuotas) {
		super(id, estado, pedido);
		this.numeroCuotas = numeroCuotas;
	}

	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	
	
}
