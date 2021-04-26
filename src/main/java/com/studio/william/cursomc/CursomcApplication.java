package com.studio.william.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.domain.Ciudad;
import com.studio.william.cursomc.domain.Estado;
import com.studio.william.cursomc.domain.Producto;
import com.studio.william.cursomc.repositories.CategoriaRepository;
import com.studio.william.cursomc.repositories.CuidadRepository;
import com.studio.william.cursomc.repositories.EstadoRepository;
import com.studio.william.cursomc.repositories.ProductoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CuidadRepository cuidadRepositroy;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Producto p1 = new Producto(null, "Computador", 2000.00);
		Producto p2 = new Producto(null, "Impresora", 800.00);
		Producto p3 = new Producto(null, "Mouse", 80.00);
		

		
		cat1.getProductos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProductos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		productoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Cundinamarca");
		Estado est2 = new Estado(null, "Medellin");
		
		Ciudad c1 = new Ciudad(null, "Cundinamarca", est1);
		Ciudad c2 = new Ciudad(null, "Medellin", est2);
		Ciudad c3 = new Ciudad(null, "Yondó", est2);
		
		est1.getCuidades().addAll(Arrays.asList(c1));
		est2.getCuidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2)); //primero los estados para mantener las relaciones...
		cuidadRepositroy.saveAll(Arrays.asList(c1, c2,c3));
	}

	
}
