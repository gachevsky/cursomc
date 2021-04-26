package com.studio.william.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studio.william.cursomc.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
