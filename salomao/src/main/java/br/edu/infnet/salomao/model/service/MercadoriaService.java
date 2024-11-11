package br.edu.infnet.salomao.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.Constantes;
import br.edu.infnet.salomao.exceptions.MercadoriaNaoEncontradoException;
import br.edu.infnet.salomao.model.domain.Mercadoria;
import br.edu.infnet.salomao.model.repository.MercadoriaRepository;

@Service
public class MercadoriaService {

	@Autowired
	private MercadoriaRepository mercadoriaRepository;	

	public Collection<Mercadoria> obterLista(){
		return (Collection<Mercadoria>) mercadoriaRepository.findAll();
	}
	
	public void incluir(Mercadoria mercadoria) {
		mercadoriaRepository.save(mercadoria);
	}
	
	public List<Mercadoria> obterListaPorPreco(float precoInicial, float precoFinal){
		return mercadoriaRepository.findByPrecoBetween(precoInicial, precoFinal);
	}

	public long obterQtde() {
		return mercadoriaRepository.count();
	}

	public void excluir(Integer id) {
		mercadoriaRepository.deleteById(id);		
	}

	public Mercadoria obterPorId(Integer id) {
		return mercadoriaRepository.findById(id).orElse(null);
	}

	public Mercadoria alterar(Integer id, float preco) {
		
		Mercadoria mercadoriaExistente = mercadoriaRepository.findById(id).orElseThrow(() -> 
			new MercadoriaNaoEncontradoException(Constantes.MSG_PRODUTO_NOT_FOUND));
		
		mercadoriaExistente.setPreco(preco);
		
		return mercadoriaRepository.save(mercadoriaExistente);
	}
}