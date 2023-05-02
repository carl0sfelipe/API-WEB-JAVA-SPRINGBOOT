package br.acc.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.acc.banco.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}