package br.acc.banco.controller;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

import br.acc.banco.model.ContaCorrente;
import br.acc.banco.service.ContaCorrenteService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

//creating RestController
@RestController
@RequestMapping("/contaCorrente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteController {

	private final ContaCorrenteService contaCorrenteService;

	//LIST all CC - OK
	@GetMapping
	private ResponseEntity<List<ContaCorrente>> getAllContaCorrente() {
		return ResponseEntity.ok(contaCorrenteService.getAllContaCorrente());
	}

	// LIST all from Agencia
	@GetMapping(path = "/agencia/{agenciaId}")
	private ResponseEntity<List<ContaCorrente>> getAllFromAgencia(@PathVariable("agenciaId") Long agenciaId) {
		return ResponseEntity.ok(contaCorrenteService.getByAgencia(agenciaId));
	}

	@GetMapping(path = "/cliente/{clienteId}")
	private ResponseEntity<List<ContaCorrente>> getAllFromCliente(@PathVariable("clienteId") Long clienteId) {
		return ResponseEntity.ok(contaCorrenteService.getByCliente(clienteId));
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/{id}")
	private ResponseEntity<?> getContaCorrente(@PathVariable("id") Long id) {
		ResponseEntity<?> response;

		try {
			ContaCorrente contaCorrente = contaCorrenteService.getContaCorrenteById(id);
			response = ResponseEntity.ok(contaCorrente);

		} catch(Exception e) {
			response = ResponseEntity.notFound().build();
		}

		return response;
	}

	//
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteContaCorrente(@PathVariable("id") Long id) {
		contaCorrenteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Criar Conta Corrente
	@PostMapping
	private ResponseEntity<?> saveContaCorrente(@RequestBody @Valid ContaCorrente contaCorrente) {
		contaCorrenteService.saveOrUpdate(contaCorrente);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// CREATE Conta from Cliente ID - OK
	@PostMapping(path = "/cliente/{clienteId}")
	private ResponseEntity<?> createFromCliente(@PathVariable("clienteId") Long clienteId, @RequestBody @Valid ContaCorrente contaCorrente) {
		contaCorrenteService.createFromCliente(clienteId, contaCorrente);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	//Depositar valor na conta
	@ApiOperation(value = "solicitação de valor de depósito", notes = "valor do depósito")
	@PostMapping(path = "/depositar/{idContaCorrente}")
	private ResponseEntity<?> depositar(@PathVariable("idContaCorrente") Long idContaCorrente, @RequestBody BigDecimal valor) {
		try {
			return ResponseEntity.ok().body(contaCorrenteService.depositar(idContaCorrente, valor));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	// Sacar valor da conta
	@ApiOperation(value = "solicitação de valor de retirada", notes = "retirar montante")
	@PostMapping(path = "/sacar/{idContaCorrente}")
	private ResponseEntity<?> sacar(@PathVariable("idContaCorrente") Long idContaCorrente, @RequestBody BigDecimal valor) {
		try {
			return ResponseEntity.ok().body(contaCorrenteService.sacar(idContaCorrente, valor));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	// Transferir valor entre contas
	@ApiOperation(value = "Solicitação de transferência de valor", notes = "valor da transferência")
	@PostMapping(path = "/{idContaCorrenteOrigem}/transferir/{idContaCorrenteDestino}")
	private ResponseEntity<?> transferir(@PathVariable("idContaCorrenteOrigem") Long idContaCorrenteOrigem, @PathVariable("idContaCorrenteDestino") Long idContaCorrenteDestino, @RequestBody BigDecimal valor) {
		try {
			return ResponseEntity.ok().body(contaCorrenteService.transferir(idContaCorrenteOrigem, idContaCorrenteDestino, valor));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
