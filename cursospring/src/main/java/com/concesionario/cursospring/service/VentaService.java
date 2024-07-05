package com.concesionario.cursospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concesionario.cursospring.entity.Venta;
import com.concesionario.cursospring.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventas;

	public Venta save(Venta venta) {
		if(venta != null)
			return ventas.save(venta);
		return null;
	}

	public List<Venta> listAll() {
		return ventas.findAll();
	}

	public Boolean deleteCoche(Venta venta) {
		if (venta != null) {
			ventas.delete(venta);
			return true;
		}
		return false;
	}

	public Boolean deleteById(Long id) {
		return(deleteCoche(findById(id).orElse(null)));
	}

	public Optional<Venta> findById(Long id){
		return ventas.findById(id);
	}
}
