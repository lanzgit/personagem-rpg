package br.edu.infnet.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.edu.infnet.model.domain.Consumivel;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ConsumivelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ConsumivelController {

	@Autowired
	private ConsumivelService consumivelService;

	@GetMapping(value = "/consumivel/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", consumivelService.getConsumiveisByUsuarioId(usuario.getId()));
		return "consumivel/lista";
	}

	@GetMapping(value = "/consumivel")
	public String telaCadastro() {
		return "consumivel/criacao";
	}

	@PostMapping(value = "/consumivel/incluir")
	public String incluir(Model model, Consumivel consumivel, @SessionAttribute("user") Usuario usuario) {

		consumivel.calcConsumivel();
		consumivel.setUsuario(usuario);
		consumivelService.addConsumivel(consumivel);
		model.addAttribute("msg", "Consumivel cadastrado com sucesso");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/consumivel/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Consumivel consumivel = consumivelService.getConsumivelById(id);
		String msg = null;
		if (consumivel.getPersonagem() != null) {
			msg = "Não foi possível excluir o item consumível";
		} else {
			consumivelService.deleteConsumivel(id);
			msg = "A " + consumivel.getNome() + " foi excluida!";
		}
		model.addAttribute("msg", msg);

		return telaLista(model, usuario);
	}

}
