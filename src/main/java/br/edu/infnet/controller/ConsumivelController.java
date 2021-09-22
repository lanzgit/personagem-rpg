package br.edu.infnet.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.edu.infnet.model.domain.Consumivel;
import br.edu.infnet.services.ConsumivelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ConsumivelController {

	@Autowired
	private ConsumivelService consumivelService;

	@GetMapping(value = "/consumivel/lista")
	public String telaLista(Model model) {

		model.addAttribute("lista", consumivelService.getAll());
		return "consumivel/lista";
	}

	@GetMapping(value = "/consumivel")
	public String telaCadastro() {
		return "consumivel/criacao";
	}

	@PostMapping(value="/consumivel/incluir")
	public String incluir(Model model, Consumivel consumivel) {
		
		consumivel.calcConsumivel();
		consumivelService.addConsumivel(consumivel);
		model.addAttribute("msg", "Consumivel cadastrado com sucesso");

		return telaLista(model);
	}

	@GetMapping(value="/consumivel/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		Consumivel consumivel = consumivelService.getConsumivelById(id);
		consumivelService.deleteConsumivel(id);
		model.addAttribute("msg", "A " + consumivel.getNome() + " foi excluida!");

		return telaLista(model);
	}
	
	

}
