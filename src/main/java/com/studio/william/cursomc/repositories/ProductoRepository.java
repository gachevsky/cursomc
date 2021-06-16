package com.studio.william.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studio.william.cursomc.domain.Categoria;
import com.studio.william.cursomc.domain.Producto;



@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	//si se crea el metodo como esta ahorita no se requiere que se ponga la consulta ni que se pongan los @Param
	@Query("SELECT DISTINCT obj FROM Producto obj INNER JOIN obj.categorias cat WHERE obj.nombre LIKE %:nombre% AND cat IN :categorias")
	Page<Producto> findDistinctByNombreContainingAndCategoriasIn(@Param("nombre") String nombre, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}