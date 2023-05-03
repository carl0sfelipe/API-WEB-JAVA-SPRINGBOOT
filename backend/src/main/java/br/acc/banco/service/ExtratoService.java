package br.acc.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.acc.banco.model.Extrato;
import br.acc.banco.repository.ExtratoRepository;

//Define a lógica de negócio
@Service
public class ExtratoService {
	@Autowired
	ExtratoRepository extratoRepository;
	
	public List<Extrato> getAllExtrato() {
		List<Extrato> extratos = new ArrayList<Extrato>();
		extratoRepository.findAll().forEach(extrato -> extratos.add(extrato));
		return extratos;
	}
	
	// Recupera um registro especifico
		public Extrato getExtratoById(long id) {
			return extratoRepository.findById(id).get();
		}

		public void saveOrUpdate(Extrato extrato) {
			extratoRepository.save(extrato);
		}
		
		public void delete(long id) {
			extratoRepository.deleteById(id);
		}
}




