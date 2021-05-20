package com.studio.william.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.domain.enums.TipoCliente;
import com.studio.william.cursomc.dto.ClienteNewDTO;
import com.studio.william.cursomc.repositories.ClienteRepository;
import com.studio.william.cursomc.resources.exception.FieldMessage;
import com.studio.william.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipo().equals(TipoCliente.PERSONANATURAL.getCod()) && !BR.isValidCNPJ(objDto.getNumeroDocumento())) {
			list.add(new FieldMessage("numeroDocumento", "no es valido el tipo de documento"));
		}
		if (objDto.getTipo().equals(TipoCliente.PERSONAJURIDICA.getCod()) && !BR.isValidTFN(objDto.getNumeroDocumento())) {
			list.add(new FieldMessage("numeroDocumento", "no es valido el tipo de documento"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "El email ya existe"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}