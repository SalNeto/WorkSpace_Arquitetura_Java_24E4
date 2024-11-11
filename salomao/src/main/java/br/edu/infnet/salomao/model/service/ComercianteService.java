package br.edu.infnet.salomao.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.model.domain.Endereco;
import br.edu.infnet.salomao.model.domain.Comerciante;
import br.edu.infnet.salomao.model.repository.ComercianteRepository;

@Service
public class ComercianteService {
	
	@Autowired
	private ComercianteRepository comercianteRepository;
	@Autowired
	private LocalizacaoService localizacaoService;

	public Comerciante incluir(Comerciante comerciante) {
		
		String cep = comerciante.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		comerciante.setEndereco(endereco);

		return comercianteRepository.save(comerciante);
	}
	
	public boolean excluir(Integer id) {
		
		comercianteRepository.deleteById(id);
		
		return true;
	}
	
	public Collection<Comerciante> obterLista(){
		return (Collection<Comerciante>) comercianteRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public List<Comerciante> obterPorNome(String nome){
		return comercianteRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public long obterQtde() {
		return comercianteRepository.count();
	}

	public Comerciante obterPorId(Integer id) {
		return comercianteRepository.findById(id).orElse(null);
	}
}