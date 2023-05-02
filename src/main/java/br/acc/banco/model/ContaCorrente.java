package br.acc.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_conta_corrente")
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaCorrente;

	@NotBlank(message = "Agencia deve ser preenchida")
	private String agencia;
	@NotBlank(message = "Número deve ser preenchido")
	private String numero;
	@Min(value = 0)
	private BigDecimal saldo = BigDecimal.ZERO;
	
// associando a lista de extratos a conta corrente
	@OneToMany(mappedBy = "contaCorrente")
	private List<Extrato> extratos = new ArrayList<Extrato>();

// associando cliente a conta corrente
	@ManyToOne
	@JoinColumn(name = "fk_cliente_id", nullable = false)
	private Cliente clienteId = new Cliente();

	public ContaCorrente() {
	}

	public ContaCorrente(Long idContaCorrente, @NotBlank(message = "Agencia deve ser preenchida") String agencia,
			@NotBlank(message = "Número deve ser preenchido") String numero, @Min(0) BigDecimal saldo,List<Extrato> extratos, Cliente cliente) {
		super();
		this.idContaCorrente = idContaCorrente;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.extratos = extratos;
		this.clienteId = clienteId;

	}

	public void depositar(BigDecimal valor) {
	    if (valor.compareTo(BigDecimal.ZERO) <= 0) {
	      throw new IllegalArgumentException("Valor de depósito deve ser maior que zero.");
	    }
	   this.saldo = this.saldo.add(valor);
	   }
	
	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public List<Extrato> getExtratos() {
		return extratos;
	}

	public void setExtratos(List<Extrato> extratos) {
		this.extratos = extratos;
	}

	public Cliente getCliente() {
		return clienteId;
	}

	public void setCliente(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
