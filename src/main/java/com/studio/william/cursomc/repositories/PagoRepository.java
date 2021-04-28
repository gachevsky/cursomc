package com.studio.william.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studio.william.cursomc.domain.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

}
