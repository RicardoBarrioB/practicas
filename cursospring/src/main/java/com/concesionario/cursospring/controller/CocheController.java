package com.concesionario.cursospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.concesionario.cursospring.entity.Coche;
import com.concesionario.cursospring.entity.enumeration.Combustible;
import com.concesionario.cursospring.excepcion.RecursoNoEncontradoExcepcion;
import com.concesionario.cursospring.service.CocheService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CocheController {
	
	@Autowired
	private CocheService cocheService;
    private String ruta = "redirect:/coches/all-coches";

	@GetMapping("/coches/all-coches")
	public String getMethodName(ModelMap c) {
		List<Coche> coches = cocheService.listAll();
        c.addAttribute("coches", coches);
		c.addAttribute("view", "coches/cochesview");
		return "_t/frame";
	}
	
	@GetMapping("/coches/eliminar-coche/{id}")
    public String eliminarCoche(@PathVariable Long id) {
		Optional<Coche> coche = cocheService.findById(id);
        if (coche.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		cocheService.deleteCoche(coche.get());
		return ruta;
    }

	@GetMapping("/coches/editar-coche/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Optional<Coche> coche = cocheService.findById(id);
        if (coche.isEmpty()) {
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);
        }
        model.addAttribute("coche", coche.get());
        model.addAttribute("combustibles", Combustible.values());
        return "/coches/editar-coche";
    }

	@PostMapping("/coches/editar-coche/{id}")
    public String editarCoche(@PathVariable Long id, @ModelAttribute Coche cocheRecibido) {
		Optional<Coche> coche = cocheService.findById(id);
        if (coche.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		coche.get().setMarca(cocheRecibido.getMarca());
		coche.get().setColor(cocheRecibido.getColor());
		coche.get().setModelo(cocheRecibido.getModelo());
		coche.get().setExposicion(cocheRecibido.getExposicion());
        coche.get().setMatricula(cocheRecibido.getMatricula());
		coche.get().setNumeroSerie(cocheRecibido.getNumeroSerie());
		coche.get().setPrecio(cocheRecibido.getPrecio());
        cocheService.calcularPegatina(coche.get());
		cocheService.save(coche.get());
		return ruta;
    }

	@GetMapping("/coches/nuevo")
    public String formularioNuevoCoche(Model model) {
        model.addAttribute("coche", new Coche());
        model.addAttribute("combustibles", Combustible.values());
        return "coches/nuevo-coche";
    }

    @PostMapping("/coches/nuevo")
    public String guardarNuevoCoche(@ModelAttribute Coche coche) {
        cocheService.calcularPegatina(coche);
        cocheService.save(coche);
        return ruta;
    }
}
