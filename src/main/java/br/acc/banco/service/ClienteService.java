package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.acc.banco.model.Cliente;
import br.acc.banco.repository.ClienteRepository;

//Define a lógica de negócio
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAllCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clienteRepository.findAll().forEach(cliente -> clientes.add(cliente));
		return clientes;
	}

	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).get(); 
	}

	public void saveOrUpdate(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public void delete(long id) {
		clienteRepository.deleteById(id);
	}

}
