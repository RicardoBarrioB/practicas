package com.concesionario.cursospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concesionario.cursospring.entity.Venta;
import com.concesionario.cursospring.entity.enumeration.TipoPago;
import com.concesionario.cursospring.excepcion.RecursoNoEncontradoExcepcion;
import com.concesionario.cursospring.service.ClienteService;
import com.concesionario.cursospring.service.CocheService;
import com.concesionario.cursospring.service.VentaService;

@Controller
@RequestMapping("/ventas")
public class VentaControler {
	@Autowired
	private VentaService ventaService;
	@Autowired
	private CocheService cocheService;
	@Autowired
	private ClienteService clienteService;
    private String ruta = "redirect:/ventas/find-all";

	@GetMapping("/find-all")
	public String getMethodName(ModelMap v) {
		List<Venta> ventas = ventaService.listAll();
        v.addAttribute("ventas", ventas);
		v.addAttribute("view", "ventas/ventasview");
		return "_t/frame";
	}
	
	@GetMapping("/eliminar-venta/{id}")
    public String eliminarCoche(@PathVariable Long id) {
		Optional<Venta> venta = ventaService.findById(id);
        if (venta.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		ventaService.deleteVenta(venta.get());
		return ruta;
    }

	@GetMapping("/editar-venta/{id}")
    public String formularioEditarVenta(@PathVariable Long id, Model model) {
        Optional<Venta> venta = ventaService.findById(id);
        if (venta.isEmpty()) {
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);
        }
        model.addAttribute("venta", venta.get());
		model.addAttribute("tiposPago", TipoPago.values());
		model.addAttribute("clientes", clienteService.listAll());
		model.addAttribute("coches", cocheService.listAll());
        return "ventas/editar-venta";
    }

	@PostMapping("/editar-venta/{id}")
    public String editarVenta(@PathVariable Long id, @ModelAttribute Venta ventaRecibida) {
		Optional<Venta> venta = ventaService.findById(id);
        if (venta.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		venta.get().setFecha(ventaRecibida.getFecha());
		venta.get().setTipoPago(ventaRecibida.getTipoPago());
		venta.get().setTotal(ventaRecibida.getTotal());
		venta.get().setCliente(ventaRecibida.getCliente());
		venta.get().setCoche(ventaRecibida.getCoche());
		ventaService.save(venta.get());
		return ruta;
    }

	@GetMapping("/nuevo")
    public String formularioNuevaVenta(Model model) {
        model.addAttribute("venta", new Venta());
		model.addAttribute("tiposPago", TipoPago.values());
		model.addAttribute("clientes", clienteService.listAll());
		model.addAttribute("coches", cocheService.listAll());
        return "ventas/nueva-venta";
    }

    @PostMapping("/nuevo")
    public String guardarNuevoCliente(@ModelAttribute Venta venta) {
        ventaService.save(venta);
        return ruta;
    }
}
