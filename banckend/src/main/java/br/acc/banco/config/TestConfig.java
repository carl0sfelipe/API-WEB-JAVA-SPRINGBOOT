package br.acc.banco.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;
import br.acc.banco.model.ContaCorrente;
import br.acc.banco.repository.AgenciaRepository;
import br.acc.banco.repository.ClienteRepository;
import br.acc.banco.repository.ContaCorrenteRepository;
import br.acc.banco.repository.ExtratoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@Autowired
	private ExtratoRepository extratoRepository;

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente = new Cliente();

		cliente.setNome("Adriano");
		cliente.setCpf("07744091426");
		cliente.setTelefone("81998771835");

		clienteRepository.save(cliente);

		Agencia agencia = new Agencia();

		agencia.setNome("agencia");
		agencia.setEndereco("endereco");
		agencia.setTelefone("telefone");
		
		ContaCorrente conta = new ContaCorrente();

		conta.setNumero("endereco");
		conta.setSaldo(new BigDecimal(10));
		
		conta.setCliente(cliente);

		agenciaRepository.saveAll(Arrays.asList(agencia));
		
		contaCorrenteRepository.saveAll(Arrays.asList(conta));
		
	}

}
