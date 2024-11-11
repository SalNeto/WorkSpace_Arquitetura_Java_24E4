package br.edu.infnet.salomao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.salomao.model.service.SouvenirService;
import br.edu.infnet.salomao.model.service.BrinquedosService;
import br.edu.infnet.salomao.model.service.MercadoriaService;
import br.edu.infnet.salomao.model.service.ComercianteService;

@Controller
public class AppController {
	
	@Autowired
	private ComercianteService comercianteService;
	@Autowired
	private MercadoriaService mercadoriaService;
	@Autowired
	private SouvenirService souvenirService;
	@Autowired
	private BrinquedosService brinquedosService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeComerciante", comercianteService.obterQtde());
		model.addAttribute("qtdeMercadoria", mercadoriaService.obterQtde());
		model.addAttribute("qtdeSouvenir", souvenirService.obterQtde());
		model.addAttribute("qtdeBrinquedos", souvenirService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/comerciante/listagem")
	public String comercianteLista(Model model) {
				
		model.addAttribute("titulo", "Listagem de comerciantees");
		model.addAttribute("listagem", comercianteService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/mercadoria/listagem")
	public String mercadoriaLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de mercadorias");
		model.addAttribute("listagem", mercadoriaService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/brinquedos/listagem")
	public String brinquedosLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de mercadorias eletrônicos");
		model.addAttribute("listagem", brinquedosService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/souvenir/listagem")
	public String souvenirLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de mercadorias souvenirs");
		model.addAttribute("listagem", souvenirService.obterLista());
		
		return telaHome(model);
	}
}