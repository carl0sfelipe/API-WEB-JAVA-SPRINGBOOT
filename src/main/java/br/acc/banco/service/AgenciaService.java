package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;
import br.acc.banco.repository.AgenciaRepository;

@Service
public class AgenciaService {
	@Autowired
	AgenciaRepository agenciaRepository;

	// Pega todos os registros da tabela cliente
	public List<Agencia> getAllAgencia() {
		List<Agencia> agencias = new ArrayList<Agencia>();
		agenciaRepository.findAll().forEach(agencia -> agencias.add(agencia));
		return agencias;
	}

	// Recupera um registro especifico
	public Agencia getAgenciaById(long id) {
		return agenciaRepository.findById(id).get();
	}

	public void saveOrUpdate(Agencia agencia) {
		agenciaRepository.save(agencia);
	}

	// Deleta um registro especifico
	public void delete(long id) {
		agenciaRepository.deleteById(id);
	}

	// POST Adicionar uma Agencia a um Cliente
	public void criarAgencia(@PathVariable(value = "clienteId") Long clienteId, @RequestBody Agencia agenciaRequest) {
//		public ResponseEntity<Agencia> createAgencia(@PathVariable(value = "clienteId") Long clienteId, @RequestBody Agencia agenciaRequest) {
		Agencia agencia = agenciaRepository.findById(clienteId).map(cliente -> {
			agenciaRequest.setCliente(cliente.getCliente());
			return agenciaRepository.save(agenciaRequest);
		}).orElse(agenciaRequest);
//				  			 .orElseThrow(() -> new ResourceNotFoundException("Não encontrado o Cliente com id = " + clienteId));
//			return new ResponseEntity<>(agencia, HttpStatus.CREATED);
	}

	// GET Consulta Agencias por Cliente
	public ResponseEntity<List<Agencia>> consultaAgenciasPorClienteId(
			@PathVariable(value = "clienteId") Long clienteId) {
		if (!agenciaRepository.existsById(clienteId)) {
//			      throw new ResourceNotFoundException("Não encontrado o Cliente com id = \" + clienteId));
		}
		List<Agencia> agencias = agenciaRepository.findByClienteId(clienteId);
		return new ResponseEntity<>(agencias, HttpStatus.OK);
	}

	// DELETE Agencias por Cliente
	public ResponseEntity<List<Agencia>> deletaAgenciasPorClienteId(@PathVariable(value = "clienteId") Long clienteId) {
		if (!agenciaRepository.existsById(clienteId)) {
//			      throw new ResourceNotFoundException("Not found Tutorial with id = " + clienteId);
		}
		agenciaRepository.deleteByClienteId(clienteId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
