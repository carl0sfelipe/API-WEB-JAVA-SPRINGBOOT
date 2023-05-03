package br.acc.banco.controller;

import java.util.List;

import br.acc.banco.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.acc.banco.model.Agencia;
import br.acc.banco.service.AgenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agencia")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AgenciaController {

	private final AgenciaService agenciaService;

	// List all Agencias - OK
	@GetMapping
	private List<Agencia> getAllAgencia() {
		return agenciaService.getAllAgencia();
	}

	// Get Agencia By ID - OK
	@GetMapping("/{id}")
	private ResponseEntity<?> getAgencia(@PathVariable("id") Long id) {
		ResponseEntity<?> response;
		try {
			Agencia agencia = agenciaService.getAgenciaById(id);
			response = ResponseEntity.ok(agencia);

		} catch(Exception e) {
			response = ResponseEntity.notFound().build();
		}

		return response;
	}

		// Delete Agencia By Id - OK
		@DeleteMapping("/{id}")
		private ResponseEntity<?> deleteAgencia(@PathVariable("id") Long id) {
			agenciaService.delete(id);
			return ResponseEntity.noContent().build();
		}

		// Create Agencia - OK
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		private ResponseEntity<Agencia> saveAgencia(@RequestBody @Valid Agencia agencia) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(agenciaService.saveOrUpdate(agencia));

		}

		// Criar Cliente com Agencia - OK
		@PostMapping(value = "/cliente/{agenciaId}",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cliente> criarAgencia(
				@PathVariable(value = "agenciaId") Long agenciaId,
				@RequestBody Cliente clienteRequest) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(agenciaService.criarCliente(agenciaId, clienteRequest));
		}

		// Consulta todos os Clientes de uma Agencia - OK
		@GetMapping("/cliente/{agenciaId}")
		public ResponseEntity<List<Cliente>> consultaClientePorAgencia(
				@PathVariable(value = "agenciaId") Long agenciaId) {

			return ResponseEntity.ok(agenciaService.consultaClientesPorAgencia(agenciaId));
		}
}
