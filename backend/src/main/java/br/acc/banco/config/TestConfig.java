package br.acc.banco.config;

import br.acc.banco.model.ContaCorrente;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;

import br.acc.banco.repository.AgenciaRepository;
import br.acc.banco.repository.ClienteRepository;
import br.acc.banco.repository.ContaCorrenteRepository;
import br.acc.banco.repository.ExtratoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Builder
@Repository
public class TestConfig implements CommandLineRunner {

	@Autowired
	private final ClienteRepository clienteRepository;

	@Autowired
	private final AgenciaRepository agenciaRepository;

	@Autowired
	private final ContaCorrenteRepository contaCorrenteRepository;

	@Autowired
	private final ExtratoRepository extratoRepository;

	@Override
	public void run(String... args) throws Exception {

		Agencia agencia = Agencia.builder()
				.nome("Teste")
				.telefone("222")
				.endereco("rea")
				.build();

		agenciaRepository.save(agencia);

		Cliente cliente = Cliente.builder()
				.agencia(agencia)
				.cpf("525.545.360-90")
				.telefone("2222")
				.nome("nome")
				.build();

		clienteRepository.save(cliente);

 		ContaCorrente contaCorrente = ContaCorrente.builder()
				.numero("2222")
				.saldo(BigDecimal.ZERO)
				.cliente(cliente)
				.build();

 		contaCorrenteRepository.save(contaCorrente);

	}

}