package com.studio.william.cursomc.services;

import java.util.Optional;

import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Pedido;
import com.studio.william.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto No encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName(), null));
	}
	
}
