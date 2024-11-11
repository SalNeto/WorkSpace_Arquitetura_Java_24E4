package br.edu.infnet.salomao.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.salomao.client.EnderecoClient;
import br.edu.infnet.salomao.client.LocalClient;
import br.edu.infnet.salomao.model.domain.Endereco;
import br.edu.infnet.salomao.model.domain.Estado;
import br.edu.infnet.salomao.model.domain.Municipio;

@Service
public class LocalizacaoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalClient localClient;

	public Endereco findByCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> obterEstados(){
		return localClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer uf){
		return localClient.obterMunicipios(uf);
	}
}
