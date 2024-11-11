package br.edu.infnet.salomao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.salomao.model.domain.Brinquedos;
import br.edu.infnet.salomao.model.service.BrinquedosService;

@RestController
public class BrinquedosController {

	@Autowired
	private BrinquedosService brinquedosService;
		
	@GetMapping(value = "/lista/brinquedos")
	public Collection<Brinquedos> obterLista(){
		
		return brinquedosService.obterLista();
	}

	@PostMapping(value = "/brinquedos/incluir")
	public String incluir(@RequestBody Brinquedos brinquedos) {
		
		brinquedosService.incluir(brinquedos);
		
		return "Inclusão realizada com sucesso.";
	}
}