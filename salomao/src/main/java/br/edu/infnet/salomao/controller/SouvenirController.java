package br.edu.infnet.salomao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.salomao.Constantes;
import br.edu.infnet.salomao.model.domain.Souvenir;
import br.edu.infnet.salomao.model.service.SouvenirService;

@RestController
@RequestMapping("/souvenirs")
public class SouvenirController {

	@Autowired
	private SouvenirService souvenirService;
		
	@GetMapping
	public ResponseEntity<Collection<Souvenir>> obterLista(){
		
		return ResponseEntity.ok(souvenirService.obterLista());
	}

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Souvenir souvenir) {
		
		souvenirService.incluir(souvenir);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@PutMapping(value = "/alterar")
	public ResponseEntity<Souvenir> alterar(@RequestBody Souvenir souvenir) {
		
		Souvenir souvenirAtualizado = souvenirService.alterar(souvenir);
		
		return ResponseEntity.ok(souvenirAtualizado);
	}
}