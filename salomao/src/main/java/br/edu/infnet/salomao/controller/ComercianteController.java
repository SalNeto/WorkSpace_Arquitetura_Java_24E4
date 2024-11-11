package br.edu.infnet.salomao.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.salomao.Constantes;
import br.edu.infnet.salomao.model.domain.Comerciante;
import br.edu.infnet.salomao.model.service.ComercianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/comerciantees")
public class ComercianteController {

	@Autowired
	private ComercianteService comercianteService;
	
	@Operation(summary = "Recupera todos os comerciantees existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Collection<Comerciante>> obterLista(){		
		return ResponseEntity.ok(comercianteService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo comerciante.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Comerciante comerciante) {
		
		comercianteService.incluir(comerciante);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um comerciante através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(comercianteService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_VENDEDOR_NOT_FOUND);
	}
	
	@Operation(summary = "Busca um comerciante através do nome.")
	@GetMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Comerciante>> obterPorNome(@PathVariable String nome){
		
		List<Comerciante> comerciantees = comercianteService.obterPorNome(nome);
		
		if(comerciantees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(comerciantees);
		}
		
		return ResponseEntity.ok(comerciantees);
	}	
	
	@Operation(summary = "Busca um comerciante através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Comerciante> obterPorId(@PathVariable Integer id) {
		
		Comerciante comerciante = comercianteService.obterPorId(id);
		
		if(comerciante == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(comerciante);
	}
}