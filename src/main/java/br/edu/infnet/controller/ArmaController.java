package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.model.domain.Arma;
import br.edu.infnet.services.ArmaService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ArmaController {

	@Autowired
	private ArmaService armaService;

	@GetMapping(value="/arma/lista")
	public String telaLista(Model model) {

		model.addAttribute("lista", armaService.getAll());
		return "arma/lista";
	}

	@GetMapping(value="/arma")
	public String telaCadastro() {
		return "arma/criacao";
	}
	
	@PostMapping(value="/arma/incluir")
	public String incluir(Model model, Arma arma) {
		
		arma.calcDano();
		armaService.addArma(arma);
		model.addAttribute("msg", "Arma cadastrada com sucesso!");
		
		return telaLista(model);
	}

	@GetMapping(value="/arma/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Arma arma = armaService.getById(id);
		armaService.deleteArma(id);
		model.addAttribute("msg", "A " + arma.getNome() + " foi excluida!");

		return telaLista(model);
	}
	
	
	
	
}
