package br.edu.infnet.salomao.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.model.domain.Eletronico;
import br.edu.infnet.salomao.model.repository.EletronicoRepository;

@Service
public class EletronicoService {

	@Autowired
	private EletronicoRepository eletronicoRepository;	

	public Collection<Eletronico> obterLista(){
		return (Collection<Eletronico>) eletronicoRepository.findAll();
	}
	
	public void incluir(Eletronico eletronico) {
		eletronicoRepository.save(eletronico);
	}

	public long obterQtde() {
		return eletronicoRepository.count();
	}
}