package br.acc.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_extrato")
public class Extrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExtrato;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
	private LocalDateTime dataHoraMovimento;

	@NotBlank(message = "Operação deve ser preenchida")
	private String operacao;

	@Min(value = 0)
	private BigDecimal valorOperacao = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "fk_conta_corrente_id", nullable = false)
	private ContaCorrente contaCorrente;

	public Extrato() {
	}

	public Extrato(Long idExtrato, LocalDateTime dataHoraMovimento, String operacao, BigDecimal valorOperacao,
			ContaCorrente contaCorrente) {
		super();
		this.idExtrato = idExtrato;
		this.dataHoraMovimento = dataHoraMovimento;
		this.operacao = operacao;
		this.valorOperacao = valorOperacao;
		this.contaCorrente = contaCorrente;
	}

	public Long getIdExtrato() {
		return idExtrato;
	}

	public void setIdExtrato(Long idExtrato) {
		this.idExtrato = idExtrato;
	}

	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
