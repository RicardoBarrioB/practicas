package com.concesionario.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concesionario.cursospring.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository <Venta, Long> {
	
}
