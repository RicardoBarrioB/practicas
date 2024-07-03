package com.gm.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.rh.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer> {

}
