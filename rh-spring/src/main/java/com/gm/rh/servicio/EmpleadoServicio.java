package com.gm.rh.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.rh.modelo.Empleado;
import com.gm.rh.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {

	@Autowired
	private EmpleadoRepositorio empleadoRepo;

	@Override
	public Optional<Empleado> buscarEmpleadoporId(Integer idEmpleado) {
		return empleadoRepo.findById(idEmpleado);
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		if (empleado != null)
			empleadoRepo.delete(empleado);	
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		if (empleado != null)
			return empleadoRepo.save(empleado);
		return null;
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoRepo.findAll();
	}
	
}
