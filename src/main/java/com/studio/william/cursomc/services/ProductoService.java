package com.studio.william.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.domain.Producto;
import com.studio.william.cursomc.repositories.CategoriaRepository;
import com.studio.william.cursomc.repositories.ProductoRepository;
import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	public Producto find(Integer id) {
		Optional<Producto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto No encontrado! Id: " + id + ", Tipo: " + Producto.class.getName(), null));
	}
	
	public Page<Producto> search(String nombre, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriarepository.findAllById(ids);
		return repo.findDistinctByNombreContainingAndCategoriasIn(nombre, categorias, pageRequest);	
	}
	
}
