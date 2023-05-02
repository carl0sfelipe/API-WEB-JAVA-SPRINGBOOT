package br.acc.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;
import jakarta.transaction.Transactional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	List<Agencia> findByClienteId(Long clienteId);

	@Transactional
	void deleteByClienteId(Long clienteId);
}
