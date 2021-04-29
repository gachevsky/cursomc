package com.studio.william.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.domain.Ciudad;
import com.studio.william.cursomc.domain.Cliente;
import com.studio.william.cursomc.domain.Direccion;
import com.studio.william.cursomc.domain.Estado;
import com.studio.william.cursomc.domain.ItemPedido;
import com.studio.william.cursomc.domain.Pago;
import com.studio.william.cursomc.domain.PagoConCheque;
import com.studio.william.cursomc.domain.PagoConCredito;
import com.studio.william.cursomc.domain.Pedido;
import com.studio.william.cursomc.domain.Producto;
import com.studio.william.cursomc.domain.enums.EstadoPago;
import com.studio.william.cursomc.domain.enums.TipoCliente;
import com.studio.william.cursomc.repositories.CategoriaRepository;
import com.studio.william.cursomc.repositories.ClienteRepository;
import com.studio.william.cursomc.repositories.CuidadRepository;
import com.studio.william.cursomc.repositories.DireccionRepository;
import com.studio.william.cursomc.repositories.EstadoRepository;
import com.studio.william.cursomc.repositories.ItemPedidoRepository;
import com.studio.william.cursomc.repositories.PagoRepository;
import com.studio.william.cursomc.repositories.PedidoRepository;
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
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DireccionRepository direccionrepository; 
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagoRepository pagoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "Maria@gmail.com", "36378912377", TipoCliente.PERSONANATURAL);
		cli1.getTelefonos().addAll(Arrays.asList("27363323","93838393"));
		
		Direccion e1 = new Direccion(null, "Calle", "26", "Apto 303", "Jardim", "38220834",cli1, c1);
		Direccion e2 = new Direccion(null, "Avenida", "26", "Sala 800", "Centro", "38220834",cli1, c2);
		
		cli1.getDirecciones().addAll(Arrays.asList(e1, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		direccionrepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("27/04/2021 10:00"),  cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2020 19:35"),  cli1, e2);
		
		Pago pago1 = new PagoConCredito(null, EstadoPago.ESTABLECIDO, ped1, e2, 6);
		
		ped1.setPago(pago1);
	
		Pago pago2 = new PagoConCheque(null, EstadoPago.PENDIENTE, ped2, sdf.parse("20/10/2020 00:00"), null);
		ped2.setPago(pago2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagoRepository.saveAll(Arrays.asList(pago1,pago2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 8001.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1,ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

	
}
