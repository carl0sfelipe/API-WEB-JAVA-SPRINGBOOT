package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.acc.banco.model.Cliente;
import br.acc.banco.repository.ClienteRepository;

//Define a lógica de negócio
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

	private ClienteRepository clienteRepository;

	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElseThrow();
	}

	public Cliente saveOrUpdate(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
