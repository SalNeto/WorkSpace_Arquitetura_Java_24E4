package br.edu.infnet.salomao.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.salomao.model.domain.Mercadoria;
import br.edu.infnet.salomao.model.service.MercadoriaService;

@RestController
public class MercadoriaController {

	@Autowired
	private MercadoriaService mercadoriaService;
		
	@GetMapping(value = "/lista/mercadoria")
	public Collection<Mercadoria> obterLista(){
		
		return mercadoriaService.obterLista();
	}

	@GetMapping(value = "/mercadorias/filtrarPorPreco")
	public ResponseEntity<List<Mercadoria>> obterListaPorPreco(@RequestParam float min, @RequestParam float max){
		
		if(min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Mercadoria> mercadorias = mercadoriaService.obterListaPorPreco(min, max);
		
		if(mercadorias.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mercadorias);
		}
		
		return ResponseEntity.ok(mercadorias);
	}	
	
	@DeleteMapping(value = "/mercadoria/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		mercadoriaService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@GetMapping(value = "/mercadoria/{id}")
	public Mercadoria obterPorId(@PathVariable Integer id) {
		return mercadoriaService.obterPorId(id);
	}

	@PatchMapping(value = "/mercadorias/alterar")
	public ResponseEntity<Mercadoria> alterar(@RequestParam Integer id, @RequestParam float preco) {
		
		Mercadoria mercadoriaAtualizado = mercadoriaService.alterar(id, preco);
		
		return ResponseEntity.ok(mercadoriaAtualizado);
	}
}