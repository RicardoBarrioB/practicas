package com.concesionario.cursospring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concesionario.cursospring.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository <Venta, Long> {
	
	@Query("SELECT v FROM Venta v WHERE v.coche.id = :cocheId")
    Optional<Venta> findByCocheId(@Param("cocheId") Long cocheId);

    @Query("SELECT v FROM Venta v WHERE v.cliente.id = :clienteId")
    List<Venta> findByClienteId(@Param("clienteId") Long clienteId);

}
