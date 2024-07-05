package com.concesionario.cursospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionario.cursospring.entity.Coche;
import com.concesionario.cursospring.repository.CocheRepository;

@Service
public class CocheService {
	
	@Autowired
	private CocheRepository coches;

	public Coche save(Coche coche) {
		if(coche != null)
			return coches.save(coche);
		return null;
	}

	public List<Coche> listAll() {
		return coches.findAll();
	}

	public Boolean deleteCoche(Coche coche) {
		if (coche != null) {
			coches.delete(coche);
			return true;
		}
		return false;
	}

	public Boolean deleteById(Long id) {
		return(deleteCoche(findById(id).orElse(null)));
	}

	public Optional<Coche> findById(Long id){
		return coches.findById(id);
	}
}
