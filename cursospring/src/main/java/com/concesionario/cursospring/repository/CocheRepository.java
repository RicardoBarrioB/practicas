package com.concesionario.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.concesionario.cursospring.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository <Coche, Long>{

}
