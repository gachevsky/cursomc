package com.studio.william.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.dto.CategoriaDTO;
import com.studio.william.cursomc.repositories.CategoriaRepository;
import com.studio.william.cursomc.services.exceptions.DataIntegrityException;
import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;

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
	
	public void delete(Integer id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No es posible eliminar una categoria que tiene productos");
		}
		 	
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerpage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerpage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	} 
	
	public Categoria fromDto(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(),objDTO.getNombre());
	}
}


