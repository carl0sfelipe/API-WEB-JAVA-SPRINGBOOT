package br.acc.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.acc.banco.model.Agencia;
import br.acc.banco.service.AgenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {
	@Autowired
	private AgenciaService agenciaService;

	@GetMapping
	private List<Agencia> getAllAgencia() {
		return agenciaService.getAllAgencia();
	}

	// creating a get mapping
	@GetMapping("/{id}")
	private Agencia getAgencia(@PathVariable("id") int id) {
		return agenciaService.getAgenciaById(id);
	}

	// creating a delete mapping that deletes a specific student
	@DeleteMapping("/{id}")
	private void deleteAgencia(@PathVariable("id") int id) {
		agenciaService.delete(id);
	}

	// salvar e alterar cliente
	@PostMapping
	private long saveAgencia(@RequestBody @Valid Agencia agencia) {
		agenciaService.saveOrUpdate(agencia);
		return agencia.getIdAgencia();

	}

	// Adicionar uma Agencia a um Cliente
	@PostMapping("/cliente/{clienteId}/agencia")
	public ResponseEntity<Agencia> criarAgencia(@PathVariable(value = "clienteId") Long clienteId,
			@RequestBody Agencia agenciaRequest) {
		agenciaService.criarAgencia(clienteId, agenciaRequest);
		return new ResponseEntity<>(agenciaRequest, HttpStatus.CREATED);
	}

	// Consulta todas as Agencias de um Cliente
	@GetMapping("/cliente/{clienteId}/agencia")
	public ResponseEntity<List<Agencia>> consultaAgenciasPorClienteId(
			@PathVariable(value = "clienteId") Long clienteId) {

		return agenciaService.consultaAgenciasPorClienteId(clienteId);
	}

	// Deletar Agencias de um Local
	@DeleteMapping("/cliente/{clienteId}/agencia")
	public ResponseEntity<List<Agencia>> deletaAgenciasPorClientelId(
			@PathVariable(value = "clienteId") Long clienteId) {
		agenciaService.deletaAgenciasPorClienteId(clienteId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
