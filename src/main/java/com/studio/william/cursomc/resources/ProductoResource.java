package com.studio.william.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studio.william.cursomc.domain.Producto;
import com.studio.william.cursomc.dto.ProductoDTO;
import com.studio.william.cursomc.resources.utils.URL;
import com.studio.william.cursomc.services.ProductoService;


@RestController
@RequestMapping(value="/productos")
public class ProductoResource {
	
	@Autowired
	private ProductoService service; 
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public ResponseEntity<Producto> find(@PathVariable Integer id) {
		Producto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProductoDTO>> findPage(
			@RequestParam(value = "nombre", defaultValue = "") String 	nombre, 
			@RequestParam(value = "categorias", defaultValue = "") String 	categorias, 
			@RequestParam(value = "page", defaultValue = "0") Integer 	page, 
			@RequestParam(value = "linesPerpage", defaultValue = "24") Integer linesPerpage, 
			@RequestParam(value = "orderBy", defaultValue = "nombre") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nombreDecoded = URL.decodeParam(nombre);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Producto> list = service.search(nombreDecoded, ids, page, linesPerpage, orderBy, direction);
		Page<ProductoDTO> listDTO = list.map(obj -> new ProductoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
