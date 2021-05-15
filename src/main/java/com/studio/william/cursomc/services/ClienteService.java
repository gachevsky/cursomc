package com.studio.william.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.studio.william.cursomc.domain.Ciudad;
import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.domain.Direccion;
import com.studio.william.cursomc.domain.enums.TipoCliente;
import com.studio.william.cursomc.dto.ClienteDTO;
import com.studio.william.cursomc.dto.ClienteNewDTO;
import com.studio.william.cursomc.repositories.ClienteRepository;
import com.studio.william.cursomc.repositories.CuidadRepository;
import com.studio.william.cursomc.repositories.DireccionRepository;
import com.studio.william.cursomc.services.exceptions.DataIntegrityException;
import com.studio.william.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private CuidadRepository cuidadRepository;
	
	@Autowired
	private DireccionRepository direccionRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto No encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		direccionRepository.saveAll(obj.getDirecciones());
		return obj;
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

	public Page<Cliente> findPage(Integer page, Integer linesPerpage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerpage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDto(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNombre(), objDTO.getEmail(), null, null);
	}

	public Cliente fromDto(ClienteNewDTO objDTO) {
		Cliente cli = new Cliente(null, objDTO.getNombre(), objDTO.getEmail(), objDTO.getNumeroDocumento(),
				TipoCliente.toEmun(objDTO.getTipo()));
		Optional<Ciudad> cid = cuidadRepository.findById(objDTO.getCuidadId());
		Direccion dir = new Direccion(null, objDTO.getCalle(), objDTO.getNumero(), objDTO.getComplemento(),
				objDTO.getBarrio(), objDTO.getCodigoPostal(), cli, cid.get());
		cli.getDirecciones().add(dir);
		cli.getTelefonos().add(objDTO.getTelefono1());
		if (objDTO.getTelefono2() != null) {
			cli.getTelefonos().add(objDTO.getTelefono2());
		}
		if (objDTO.getTelefono3() != null) {
			cli.getTelefonos().add(objDTO.getTelefono3());
		}
		return cli;
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNombre(obj.getNombre());
		newObj.setEmail(obj.getEmail());
	}

}
