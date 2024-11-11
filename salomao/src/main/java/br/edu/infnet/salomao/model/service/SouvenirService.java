package br.edu.infnet.salomao.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.Constantes;
import br.edu.infnet.salomao.exceptions.MercadoriaNaoEncontradoException;
import br.edu.infnet.salomao.model.domain.Souvenir;
import br.edu.infnet.salomao.model.repository.SouvenirRepository;

@Service
public class SouvenirService {

	@Autowired
	private SouvenirRepository souvenirRepository;	

	public Collection<Souvenir> obterLista(){
		return (Collection<Souvenir>) souvenirRepository.findAll();
	}
	
	public void incluir(Souvenir souvenir) {
		souvenirRepository.save(souvenir);
	}

	public Souvenir alterar(Souvenir souvenir) {
		
		if(!souvenirRepository.existsById(souvenir.getId())) {
			throw new MercadoriaNaoEncontradoException(Constantes.MSG_PRODUTO_NOT_FOUND);
		}
		
		return souvenirRepository.save(souvenir);
	}
	
	public long obterQtde() {
		return souvenirRepository.count();
	}
}