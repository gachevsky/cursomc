package com.studio.william.cursomc.services;

import java.util.Optional;

import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto No encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	}
	
}
