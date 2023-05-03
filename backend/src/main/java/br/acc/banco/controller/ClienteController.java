package br.acc.banco.controller;

import java.net.URI;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

	private final ClienteService clienteService;

//	@Autowired
//	public ClienteController(ClienteService service) {
//		this.clienteService = service
//	}

	// retorna todos os clientes - OK
	@GetMapping
	private ResponseEntity<List<Cliente>> getAllCliente() {
		return ResponseEntity.ok(clienteService.getAllCliente());
	}

	// retorno cliente pelo id - OK
	@GetMapping("/{id}")
	private ResponseEntity<?> getCliente(@PathVariable("id") Long id) {
		ResponseEntity<?> response;

		try {
			Cliente cliente = clienteService.getClienteById(id);
			response = ResponseEntity.ok(cliente);

		} catch(Exception e) {
			response = ResponseEntity.notFound().build();
		}

		return response;
	}


	// Delete Cliente By ID - OK
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteCliente(@PathVariable("id") Long id) {
		ResponseEntity<?> response;

		try {
			clienteService.delete(id);
			response = ResponseEntity.noContent().build();

		} catch(Exception e) {
			response = ResponseEntity.notFound().build();
		}

		return response;
	}

	// Create Cliente if not Exists or Update if exists - OK
	@PostMapping
	private ResponseEntity<Cliente> saveCliente(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(clienteService.saveOrUpdate(cliente));
	}

}
