package br.acc.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_conta_corrente")
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaCorrente;

	@NotBlank(message = "Número deve ser preenchido")
	private String numero;

	@Min(value = 0)
	private BigDecimal saldo = BigDecimal.ZERO;

// associando cliente a conta corrente
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Cliente cliente;

	public void depositar (BigDecimal valor){
		if(valor.compareTo(this.saldo) != 1 || valor.equals(BigDecimal.ZERO)){
			throw new IllegalArgumentException("Valor inválido para deposito");
		} else{
			this.saldo.add(valor);
		}
	}
	public void sacar (BigDecimal valor){
		if(valor.compareTo(this.saldo) >= 0){
			throw new IllegalArgumentException("Valor inválido para saque");
		} else{
			this.saldo.subtract(valor);
		}
	}
	public void transferir (BigDecimal valor, ContaCorrente destino){
		if(valor.compareTo(this.saldo) >= 0){
			throw new IllegalArgumentException("Valor inválido para Transferencia");
		} else{
			this.sacar(valor);
			destino.depositar(valor);
		}
	}

}
