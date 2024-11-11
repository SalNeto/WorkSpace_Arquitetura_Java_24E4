package br.edu.infnet.salomao;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.salomao.model.domain.Souvenir;
import br.edu.infnet.salomao.model.domain.Brinquedos;
import br.edu.infnet.salomao.model.domain.Endereco;
import br.edu.infnet.salomao.model.domain.Estado;
import br.edu.infnet.salomao.model.domain.Municipio;
import br.edu.infnet.salomao.model.domain.Comerciante;
import br.edu.infnet.salomao.model.service.LocalizacaoService;
import br.edu.infnet.salomao.model.service.MercadoriaService;
import br.edu.infnet.salomao.model.service.ComercianteService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private ComercianteService comercianteService;
	@Autowired
	private LocalizacaoService localizacaoService;
	@Autowired
	private MercadoriaService mercadoriaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(Estado estado : localizacaoService.obterEstados()) {
			System.out.println("ESTADO: " + estado.getNome());
		}
		
		for(Municipio municipio : localizacaoService.obterMunicipios(33)) {
			System.out.println("MUNICÍPIO: " + municipio.getNome());
		}
		
		FileReader file = new FileReader("files/comerciantees.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		
		Comerciante comerciante = null;

		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "V":
				
				comerciante = new Comerciante();			
				comerciante.setCpf(campos[1]);
				comerciante.setEmail(campos[2]);
				comerciante.setNome(campos[3]);
				comerciante.setEndereco(new Endereco(campos[4]));				
								
				comerciante = comercianteService.incluir(comerciante);
				
				System.out.println("VENDEDOR ["+comerciante+"]");
				
				break;

			case "A":
				Souvenir souvenir = new Souvenir();
				souvenir.setCodigo(Integer.valueOf(campos[1]));
				souvenir.setDescricao(campos[2]);
				souvenir.setEstoque(Boolean.valueOf(campos[3]));
				souvenir.setPreco(Float.valueOf(campos[4]));
				souvenir.setCaracteristica(campos[5]);
				souvenir.setOrganico(Boolean.valueOf(campos[6]));
				souvenir.setComerciante(comerciante);
				
				mercadoriaService.incluir(souvenir);
				
				comerciante.getMercadorias().add(souvenir);				
				
				break;

			case "E":
				
				Brinquedos brinquedos = new Brinquedos();
				brinquedos.setCodigo(Integer.valueOf(campos[1]));
				brinquedos.setDescricao(campos[2]);
				brinquedos.setEstoque(Boolean.valueOf(campos[3]));
				brinquedos.setPreco(Float.valueOf(campos[4]));
				brinquedos.setMarca(campos[5]);
				brinquedos.setGarantiaMeses(Integer.valueOf(campos[6]));
				brinquedos.setComerciante(comerciante);
				
				mercadoriaService.incluir(brinquedos);
				
				comerciante.getMercadorias().add(brinquedos);				
				
				break;

			default:
				break;
			}
					
			linha = leitura.readLine();
		}
		
		for(Comerciante v: comercianteService.obterLista()) {
			System.out.println("Comerciante cadastrado com sucesso: " + v);			
		}
		
		// CHAMADA DOS SERVICES
		System.out.println("## findByNomeContaining - nasser ## " + comercianteService.obterPorNome("nasser"));
		System.out.println("## findByNomeContaining - silva ## " + comercianteService.obterPorNome("silva"));

		leitura.close();
	}
}