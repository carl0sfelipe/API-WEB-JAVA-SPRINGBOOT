package br.acc.banco.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.acc.banco.model.Cliente;
import br.acc.banco.service.ClienteService;
import jakarta.validation.Valid;

//creating RestController
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	// injetando dependencia
	@Autowired
	private ClienteService clienteService;

	// retorna todos os clientes
	@GetMapping
	private List<Cliente> getAllCliente() {
		return clienteService.getAllCliente();
	}

	// retorno cliente pelo id
	@GetMapping("/{id}")
	private Cliente getCliente(@PathVariable("id") int id) {
		return clienteService.getClienteById(id);
	}

	// deleta cliente pelo id
	@DeleteMapping("/{id}")
	private void deleteCliente(@PathVariable("id") int id) {
		clienteService.delete(id);
	}

	// salva e atualiza cliente
	@PostMapping
	private long saveCliente(@RequestBody @Valid Cliente cliente) {
		clienteService.saveOrUpdate(cliente);
		return cliente.getCliente();
		// return 123;
	}

}
