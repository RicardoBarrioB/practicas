package com.concesionario.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.concesionario.cursospring.entity.Coche;

public interface CocheRepository extends JpaRepository <Coche, Long>{

}
