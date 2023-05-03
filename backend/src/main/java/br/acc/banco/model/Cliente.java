package br.acc.banco.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;

	@NotBlank(message = "Nome deve ser preenchido")
	private String nome;

	@NotBlank(message = "CPF deve ser preenchido")
	@CPF(message = "CPF inválido")
	private String cpf;

	@NotBlank(message = "Nome deve ser preenchido")
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_agencia", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Agencia agencia;

}