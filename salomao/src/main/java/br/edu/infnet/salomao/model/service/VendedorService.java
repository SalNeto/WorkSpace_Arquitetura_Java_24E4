package br.edu.infnet.salomao.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.model.domain.Endereco;
import br.edu.infnet.salomao.model.domain.Vendedor;
import br.edu.infnet.salomao.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private LocalizacaoService localizacaoService;

	public Vendedor incluir(Vendedor vendedor) {
		
		String cep = vendedor.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		vendedor.setEndereco(endereco);

		return vendedorRepository.save(vendedor);
	}
	
	public boolean excluir(Integer id) {
		
		vendedorRepository.deleteById(id);
		
		return true;
	}
	
	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}
	
	public List<Vendedor> obterPorNome(String nome){
		return vendedorRepository.findByNomeContaining(nome);
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}

	public Vendedor obterPorId(Integer id) {
		return vendedorRepository.findById(id).orElse(null);
	}
}