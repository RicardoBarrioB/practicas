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
	private VentaRepository ventaRepository;

	public Venta save(Venta venta) {
		if(venta != null)
			return ventaRepository.save(venta);
		return null;
	}

	public List<Venta> listAll() {
		return ventaRepository.findAll();
	}

	public Boolean deleteVenta(Venta venta) {
		if (venta != null) {
			ventaRepository.delete(venta);
			return true;
		}
		return false;
	}

	public Boolean deleteById(Long id) {
		return(deleteVenta(findById(id).orElse(null)));
	}

	public Optional<Venta> findById(Long id){
		return ventaRepository.findById(id);
	}

	public Optional<Venta> findByCocheId(Long id)
	{
		return (ventaRepository.findByCocheId(id));
	}

	public List<Venta> findByClienteId(Long id)
	{
		return (ventaRepository.findByClienteId(id));
	}
}
