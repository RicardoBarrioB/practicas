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

import com.concesionario.cursospring.entity.Cliente;
import com.concesionario.cursospring.excepcion.RecursoNoEncontradoExcepcion;
import com.concesionario.cursospring.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
    private String ruta = "redirect:/clientes/all-clientes";

	@GetMapping("/all-clientes")
	public String getMethodName(ModelMap c) {
		List<Cliente> clientes = clienteService.listAll();
        c.addAttribute("clientes", clientes);
		c.addAttribute("view", "clientes/clientesview");
		return "_t/frame";
	}
	
	@GetMapping("/eliminar-cliente/{id}")
    public String eliminarCoche(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		clienteService.deleteCliente(cliente.get());
		return ruta;
    }

	@GetMapping("/editar-cliente/{id}")
    public String formularioEditarCliente(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isEmpty()) {
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);
        }
        model.addAttribute("cliente", cliente.get());
        return "clientes/editar-cliente";
    }

	@PostMapping("/editar-cliente/{id}")
    public String editarCliente(@PathVariable Long id, @ModelAttribute Cliente clienteRecibido) {
		Optional<Cliente> cliente = clienteService.findById(id);
        if (cliente.isEmpty())
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe:" + id);
		cliente.get().setDni(clienteRecibido.getDni());
		cliente.get().setNombre(clienteRecibido.getNombre());
		cliente.get().setNumCompras(clienteRecibido.getNumCompras());
		clienteService.save(cliente.get());
		return ruta;
    }

	@GetMapping("/nuevo")
    public String formularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/nuevo-cliente";
    }

    @PostMapping("/nuevo")
    public String guardarNuevoCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return ruta;
    }
}
