package br.acc.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;


	public void depositar (BigDecimal valor){
		if(valor.compareTo(BigDecimal.ZERO) > 0 ){
			throw new IllegalArgumentException("Valor inválido para deposito");
		} else{
			this.saldo.add(valor);
		}
	}
	public void sacar (BigDecimal valor){
		if(valor.compareTo(this.saldo) >= 0 && !valor.equals(BigDecimal.ZERO)){
			throw new IllegalArgumentException("Valor inválido para saque");
		} else{
			this.saldo.subtract(valor);
		}
	}
	public void transferir (BigDecimal valor, ContaCorrente destino){
		this.sacar(valor);
		destino.depositar(valor);
	}

}
