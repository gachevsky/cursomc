package com.studio.william.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity	
public class ItemPedido implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItenPedidoPK id = new ItenPedidoPK();
	
	private Double descuento;
	private Double precio;
	private Integer cantidad;
	
	public ItemPedido() {
	}
	public ItemPedido(Pedido pedido, Producto producto, Double descuento, Integer cantidad, Double precio) {
		super();
		id.setPedido(pedido);
		id.setProducto(producto);
		this.descuento = descuento;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	
	public Producto getProducto() {
		return id.getProducto();
	}
	
	
	public ItenPedidoPK getId() {
		return id;
	}
	public void setId(ItenPedidoPK id) {
		this.id = id;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
