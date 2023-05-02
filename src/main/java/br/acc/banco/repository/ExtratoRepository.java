package br.acc.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.acc.banco.model.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato,Long>{

}

