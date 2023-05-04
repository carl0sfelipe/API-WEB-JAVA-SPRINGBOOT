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
	
	
	/**
	 * sacar dinheiro da conta
	 * @param idContaCorrente
	 * @param valor
	 */
	public String sacar(Long idContaCorrente, BigDecimal valor) {
		String msg = "";
		try {
			ContaCorrente contaCorrente = getContaCorrenteById(idContaCorrente);
			if(contaCorrente.getSaldo().compareTo(BigDecimal.ZERO) == 0) {
				msg = "Saldo insuficiente"; //Insufficient balance
				return msg;
			}
			
			if(valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
				contaCorrente.setSaldo(contaCorrente.getSaldo().subtract(valor));
				saveOrUpdate(contaCorrente);
				msg = "Valor sacado com sucesso"; //Amount Withdrawn successfully
			}
			else {
				msg = "Valor inválido fornecido"; //Invalid amount provided
			}
		} catch (Exception e) {
			msg = e.getMessage();
			if("No value present".equals(msg)) {
				msg = "Conta não encontrada"; //account not found
			}
		}
		return msg;
	}
	
	
	/**
	 * depositar dinheiro na conta
	 * @param idContaCorrente
	 * @param valor
	 */
	public String depositar(Long idContaCorrente, BigDecimal valor) {
		String msg = "";
		try {
			ContaCorrente contaCorrente = getContaCorrenteById(idContaCorrente);
			if(valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
				contaCorrente.setSaldo(contaCorrente.getSaldo().add(valor));
				saveOrUpdate(contaCorrente);
				msg = "Valor depositado com sucesso"; //Amount deposited successfully
			}
			else {
				msg = "Valor inválido fornecido"; //Invalid amount provided
			}
		} catch (Exception e) {
			msg = e.getMessage();
			if("No value present".equals(msg)) {
				msg = "Conta de depósito não encontrada"; // Deposit account not found
			}
		}
		return msg;
	}

	
	/**
	 * Transferir dinheiro da origem ao destino
	 * @param idContaCorrenteOrigem
	 * @param idContaCorrenteDestino
	 * @param valor
	 */
	public String transferir(Long idContaCorrenteOrigem, Long idContaCorrenteDestino, BigDecimal valor) {
		String msg = "";
		try {
			ContaCorrente origem = getContaCorrenteById(idContaCorrenteOrigem);
			ContaCorrente destino = getContaCorrenteById(idContaCorrenteDestino);
			
			if(valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
				if(origem.getSaldo() != null && origem.getSaldo().compareTo(valor) >= 0) {
					origem.setSaldo(origem.getSaldo().subtract(valor));
					saveOrUpdate(origem);
					
					destino.setSaldo(destino.getSaldo().add(valor));
					saveOrUpdate(destino);
					
					msg = "Dinheiro transferido com sucesso"; //Money transferred successfully
				}
				else {
					msg = "Insufficient balance in the sender account"; //Insufficient balance in the sender account
				}	
			}
			else {
				msg = "Valor inválido fornecido"; //Invalid amount provided
			}
		} catch (Exception e) {
			msg = e.getMessage();
			if("No value present".equals(msg)) {
				msg = "Conta não encontrada"; // account not found
			}
		}
		return msg;
	}
	
	
}
