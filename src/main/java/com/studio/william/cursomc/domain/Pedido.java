package com.studio.william.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date fechaPedido;

	//@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pago pago;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	//@JsonManagedReference
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "direccion_de_entrega_id")
	private Direccion direccionDeEntrega;

	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> items = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Integer id, Date fechaPedido, Cliente cliente, Direccion direccionDeEntrega) {
		super();
		this.id = id;
		this.fechaPedido = fechaPedido;
//		this.pago = pago;
		this.cliente = cliente;
		this.direccionDeEntrega = direccionDeEntrega;
	}

	public double getValorTotal() {
		double suma = 0.0;
		for (ItemPedido itemPedido : items) {
			suma = suma + itemPedido.getSubTotal();
		}
		return suma;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Direccion getDireccionDeEntrega() {
		return direccionDeEntrega;
	}

	public void setDireccionDeEntrega(Direccion direccionDeEntrega) {
		this.direccionDeEntrega = direccionDeEntrega;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
