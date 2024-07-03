package com.gm.rh.controlador;

import org.springframework.web.bind.annotation.RestController;

import com.gm.rh.modelo.Empleado;
import com.gm.rh.servicio.IEmpleadoServicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

	@Autowired
	private IEmpleadoServicio empleadoServicio;

	@GetMapping("/empleados")
	public List<Empleado> obtenerEmpleados(){
		List<Empleado> empleados = empleadoServicio.listarEmpleados();
		empleados.forEach((empleado -> logger.info(empleado.toString())));
		return empleados;
	}
	

}
