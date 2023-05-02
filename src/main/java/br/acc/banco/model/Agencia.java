package br.acc.banco.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_agencia")
public class Agencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgencia;

	@NotBlank(message = "Nome Agencia deve ser preenchido")
	private String nome;

	@NotBlank(message = "Endereço deve ser preenchido")
	private String endereco;

	@NotBlank(message = "Telefone deve ser preenchido")
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "fk_cliente_id", nullable = false)
	private Cliente clienteId = new Cliente();

	public Agencia() {
	}

	public Agencia(long idAgencia, @NotBlank(message = "Nome Agencia deve ser preenchido") String nome,
			@NotBlank(message = "Endereço deve ser preenchido") String endereco,
			@NotBlank(message = "Telefone deve ser preenchido") String telefone, Cliente clienteId) {
		super();
		this.idAgencia = idAgencia;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.clienteId = clienteId;
	}

	public long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
