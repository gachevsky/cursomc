package com.studio.william.cursomc.services;

import java.util.Optional;

import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto No encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
