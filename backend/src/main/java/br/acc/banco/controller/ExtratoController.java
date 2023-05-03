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

import br.acc.banco.model.Extrato;
import br.acc.banco.service.ExtratoService;
import jakarta.validation.Valid;

//creating RestController
@RestController
@RequestMapping("/extrato")
public class ExtratoController {
	@Autowired
	ExtratoService extratoService;
	
	@GetMapping
	private List<Extrato> getAllExtrato() {
		return extratoService.getAllExtrato();
	}
	
	@GetMapping("/{id}")
	private Extrato getExtrato(@PathVariable("id") int id) {
		return extratoService.getExtratoById(id);
	}
	
	@DeleteMapping("/{id}")
	private void deleteExtrato(@PathVariable("id") int id) {
		extratoService.delete(id);
	}

	@PostMapping
	private long saveExtrato(@RequestBody @Valid Extrato extrato) {
		extratoService.saveOrUpdate(extrato);
		return extrato.getIdExtrato();
		
	}
}


