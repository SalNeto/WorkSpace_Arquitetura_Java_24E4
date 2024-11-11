package br.edu.infnet.salomao.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.model.domain.Brinquedos;
import br.edu.infnet.salomao.model.repository.BrinquedosRepository;

@Service
public class BrinquedosService {

	@Autowired
	private BrinquedosRepository brinquedosRepository;	

	public Collection<Brinquedos> obterLista(){
		return (Collection<Brinquedos>) brinquedosRepository.findAll();
	}
	
	public void incluir(Brinquedos brinquedos) {
		brinquedosRepository.save(brinquedos);
	}

	public long obterQtde() {
		return brinquedosRepository.count();
	}
}