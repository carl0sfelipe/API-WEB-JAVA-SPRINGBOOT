package br.acc.banco.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;
import br.acc.banco.repository.AgenciaRepository;
import br.acc.banco.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.acc.banco.model.ContaCorrente;
import br.acc.banco.repository.ContaCorrenteRepository;

//Define a lógica de negócio
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteService {

	private final ContaCorrenteRepository contaCorrenteRepository;
	private final AgenciaRepository agenciaRepository;
	private final ClienteRepository clienteRepository;

	// Pega todos os registros da tabela contaCorrente
	public List<ContaCorrente> getAllContaCorrente() {
		return contaCorrenteRepository.findAll();
	}

	public List<ContaCorrente> getByAgencia(Long agenciaId) {
		Agencia agencia = agenciaRepository.findById(agenciaId).orElseThrow();

		return contaCorrenteRepository.findByAgencia(agenciaId);
	}

	public List<ContaCorrente> getByCliente(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
		return contaCorrenteRepository.findByCliente(cliente);
	}

	// Recupera um registro especifico
	public ContaCorrente getContaCorrenteById(Long id) {
		return contaCorrenteRepository.findById(id).orElseThrow();
	}

	public void saveOrUpdate(ContaCorrente contaCorrente) {
		contaCorrenteRepository.save(contaCorrente);
	}

	// Deleta um registro especifico
	public void delete(Long id) {
		contaCorrenteRepository.deleteById(id);
	}

	public ContaCorrente createFromCliente(Long clienteId, ContaCorrente contaCorrente) {
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
		contaCorrente.setCliente(cliente);

		return contaCorrenteRepository.save(contaCorrente);
	}

	public void depositar(Long idContaCorrente, BigDecimal valor) {
		ContaCorrente contaCorrente = getContaCorrenteById(idContaCorrente);
		contaCorrente.depositar(valor);
		saveOrUpdate(contaCorrente);
	}

	public void sacar(Long idContaCorrente, BigDecimal valor) {
		ContaCorrente contaCorrente = getContaCorrenteById(idContaCorrente);
		contaCorrente.sacar(valor);
		saveOrUpdate(contaCorrente);
	}

	public void transferir(Long idContaCorrenteOrigem, Long idContaCorrenteDestino, BigDecimal valor) {
		ContaCorrente contaCorrenteOrigem = getContaCorrenteById(idContaCorrenteOrigem);
		ContaCorrente contaCorrenteDestino = getContaCorrenteById(idContaCorrenteDestino);
		contaCorrenteOrigem.transferir(valor, contaCorrenteDestino);
		saveOrUpdate(contaCorrenteOrigem);
		saveOrUpdate(contaCorrenteDestino);
	}

}
