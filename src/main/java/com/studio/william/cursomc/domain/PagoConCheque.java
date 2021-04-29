package com.studio.william.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studio.william.cursomc.domain.enums.EstadoPago;
@Entity
public class PagoConCheque extends Pago {

	private static final long serialVersionUID = 1L;

	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaVencimiento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaPago;
	
	
	public PagoConCheque() {
	}
	public PagoConCheque(Integer id, EstadoPago estado, Pedido pedido, Date fechavencimiento,   Date fechaPago) {
		super(id, estado, pedido);
		this.fechaVencimiento = fechavencimiento;
		this.fechaPago = fechaPago;
	}
	
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
}
