package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.acc.banco.model.ContaCorrente;
import br.acc.banco.repository.ContaCorrenteRepository;

//Define a lógica de negócio
@Service
public class ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	// Pega todos os registros da tabela contaCorrente
	public List<ContaCorrente> getAllContaCorrente() {
		List<ContaCorrente> contaCorrentes = new ArrayList<ContaCorrente>();
		contaCorrenteRepository.findAll().forEach(contaCorrente -> contaCorrentes.add(contaCorrente));
		return contaCorrentes;
	}

	// Recupera um registro especifico
	public ContaCorrente getContaCorrenteById(long id) {
		return contaCorrenteRepository.findById(id).get();
	}

	public void saveOrUpdate(ContaCorrente contaCorrente) {
		contaCorrenteRepository.save(contaCorrente);
	}

	// Deleta um registro especifico
	public void delete(long id) {
		contaCorrenteRepository.deleteById(id);
	}
}
