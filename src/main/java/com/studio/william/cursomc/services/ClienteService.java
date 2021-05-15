package com.studio.william.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.dto.ClienteDTO;
import com.studio.william.cursomc.repositories.ClienteRepository;
import com.studio.william.cursomc.services.exceptions.DataIntegrityException;
import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto No encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	


	public void delete(Integer id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No es posible eliminar por integridad de clases");
		}
		 	
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerpage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerpage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	} 
	
	public Cliente fromDto(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNombre(), objDTO.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNombre(obj.getNombre());
		newObj.setEmail(obj.getEmail());
	}
	
}
