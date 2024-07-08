package com.concesionario.cursospring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concesionario.cursospring.entity.Cliente;
import com.concesionario.cursospring.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {
		if(cliente != null)
			return clienteRepository.save(cliente);
		return null;
	}

	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}

	public Boolean deleteCliente(Cliente cliente) {
		if (cliente != null) {
			clienteRepository.delete(cliente);
			return true;
		}
		return false;
	}

	public Boolean deleteById(Long id) {
		return(deleteCliente(findById(id).orElse(null)));
	}

	public Optional<Cliente> findById(Long id){
		return clienteRepository.findById(id);
	}
}
