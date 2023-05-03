package br.acc.banco.repository;

import br.acc.banco.model.Agencia;
import br.acc.banco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.acc.banco.model.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    List<ContaCorrente> findByCliente(Cliente cliente);

    @Query(value = "SELECT * " +
            "FROM tb_conta_corrente cc " +
            "INNER JOIN tb_cliente c ON cc.cliente_cliente_id = c.cliente_id " +
            "WHERE c.id_agencia = :agenciaId", nativeQuery = true)
    List<ContaCorrente> findByAgencia(@Param("agenciaId") Long agenciaId);
}