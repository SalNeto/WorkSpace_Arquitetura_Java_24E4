package br.edu.infnet.salomao.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.model.domain.Produto;
import br.edu.infnet.salomao.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;	

	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public List<Produto> obterListaPorPreco(float precoInicial, float precoFinal){
		return produtoRepository.findByPrecoBetween(precoInicial, precoFinal);
	}

	public long obterQtde() {
		return produtoRepository.count();
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);		
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
}