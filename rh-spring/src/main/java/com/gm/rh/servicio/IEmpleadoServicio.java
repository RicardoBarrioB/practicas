package com.gm.rh.servicio;

import java.util.List;
import java.util.Optional;

import com.gm.rh.modelo.Empleado;

public interface IEmpleadoServicio {

	public List<Empleado> listarEmpleados();

	public Optional<Empleado> buscarEmpleadoporId(Integer idEmpleado);

	public Empleado guardarEmpleado(Empleado empleado);

	public void eliminarEmpleado(Empleado empleado);
}
