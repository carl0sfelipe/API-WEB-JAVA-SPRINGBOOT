package br.acc.banco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;

	@NotBlank(message = "Nome deve ser preenchido")
	private String nome;

	@NotBlank(message = "CPF deve ser preenchido")
	@CPF(message = "CPF inválido")
	private String cpf;

	@NotBlank(message = "Nome deve ser preenchido")
	private String telefone;

	@OneToMany(mappedBy = "clienteId")
	private List<Agencia> agencias = new ArrayList<Agencia>();

	@OneToMany(mappedBy = "clienteId")
	private List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public Cliente() {

	}

	public Cliente(long idCliente, String nome, String cpf, String telefone, List<Agencia> agencias,
			List<ContaCorrente> contas) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.agencias = agencias;
		this.contas = contas;
	}

	public long getCliente() {
		return idCliente;
	}

	public void setCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrente> contas) {
		this.contas = contas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}