package br.acc.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.acc.banco.model.ContaCorrente;
import br.acc.banco.service.ContaCorrenteService;
import jakarta.validation.Valid;

//creating RestController
@RestController
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {
	// injetando dependencia
	@Autowired
	ContaCorrenteService contaCorrenteService;

	// creating a get mapping that retrieves all the Local detail from the database

	@GetMapping
	private List<ContaCorrente> getAllContaCorrente() {
		return contaCorrenteService.getAllContaCorrente();
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/{id}")
	private ContaCorrente getContaCorrente(@PathVariable("id") int id) {
		return contaCorrenteService.getContaCorrenteById(id);
	}

	// creating a delete mapping that deletes a specific student
	@DeleteMapping("/{id}")
	private void deleteContaCorrente(@PathVariable("id") int id) {
		contaCorrenteService.delete(id);
	}

	// salvar e alterar contaCorrente
	@PostMapping
	private long saveContaCorrente(@RequestBody @Valid ContaCorrente contaCorrente) {
		contaCorrenteService.saveOrUpdate(contaCorrente);
		return contaCorrente.getIdContaCorrente();
		// return 123;
	}
}
