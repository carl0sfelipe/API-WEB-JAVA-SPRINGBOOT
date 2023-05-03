package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.acc.banco.model.ContaCorrente;
import br.acc.banco.repository.ClienteRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AgenciaService {

	private final AgenciaRepository agenciaRepository;
	private final ClienteRepository clienteRepository;

	// Pega todos os registros da tabela cliente
	public List<Agencia> getAllAgencia() {
		return agenciaRepository.findAll();
	}

	// Recupera um registro especifico
	public Agencia getAgenciaById(long id) {
		return agenciaRepository.findById(id).orElseThrow();
	}

	public Agencia saveOrUpdate(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

	// Deleta um registro especifico
	public void delete(long id) {
		agenciaRepository.deleteById(id);
	}

	// POST Criar Cliente com a Agência
	public Cliente criarCliente(Long agenciaId, Cliente clienteRequest) {
		Agencia agencia = agenciaRepository.findById(agenciaId).orElseThrow();
		clienteRequest.setAgencia(agencia);

		return clienteRepository.save(clienteRequest);
	}

	// GET Consulta Agencias por Cliente
	public List<Cliente> consultaClientesPorAgencia(Long agenciaId) {
		Agencia agencia = agenciaRepository.findById(agenciaId).orElseThrow();
		return clienteRepository.findByAgencia(agencia);
	}

	// DELETE Agencias por Cliente
	public ResponseEntity<List<Agencia>> deletaAgenciasPorClienteId(@PathVariable(value = "clienteId") Long clienteId) {
		if (!agenciaRepository.existsById(clienteId)) {
//			      throw new ResourceNotFoundException("Not found Tutorial with id = " + clienteId);
		}
		clienteRepository.deleteById(clienteId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
