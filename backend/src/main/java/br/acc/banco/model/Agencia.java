package br.acc.banco.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_agencia")
public class Agencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgencia;

	@NotBlank(message = "Nome Agencia deve ser preenchido")
	private String nome;

	@NotBlank(message = "Endereço deve ser preenchido")
	private String endereco;

	@NotBlank(message = "Telefone deve ser preenchido")
	private String telefone;

}
