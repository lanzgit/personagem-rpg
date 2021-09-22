package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.model.domain.Armadura;
import br.edu.infnet.services.ArmaduraService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ArmaduraController {

	@Autowired
	private ArmaduraService armaduraService;

	@GetMapping(value="/armadura/lista")
	public String telaLista(Model model) {

		model.addAttribute("lista", armaduraService.getAll());
		return "armadura/lista";
	}

	@GetMapping(value="/armadura")
	public String telaCadastro() {
		return "armadura/criacao";
	}
	
	@PostMapping(value="/armadura/incluir")
	public String incluir(Model model, Armadura armadura) {
		
		armadura.calcDef();
		armaduraService.addArmadura(armadura);
		model.addAttribute("msg", "Armadura cadastrada com sucesso!");
		
		return telaLista(model);
	}

	@GetMapping(value="/armadura/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Armadura armadura = armaduraService.getById(id);
		armaduraService.deleteArmadura(id);
		model.addAttribute("msg", "A " + armadura.getNome() + " foi excluida!");

		return telaLista(model);
	}
	
	
	
	
}
