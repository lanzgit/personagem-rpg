package br.edu.infnet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import br.edu.infnet.model.domain.Equipe;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.EquipamentoService;
import br.edu.infnet.services.EquipeService;
import br.edu.infnet.services.PersonagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	@Autowired
	private PersonagemService personagemService;
	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping(value = "/equipe/lista")
	public String listEquipe(Model model, @SessionAttribute("user") Usuario usuario, Equipe equipe) {

		model.addAttribute("lista", equipeService.getAll(usuario));
		return "equipe/lista";
	}

	@GetMapping(value = "/equipe/personagens/lista")
	public String listPersonagensDaEquipe(Model model, Equipe equipe) {

		// model.addAttribute("listaPersonagem",
		// personagemService.getAllByEquipeId(equipe));
		return "equipe/personagens/lista";
	}

	@GetMapping(value = "/equipe")
	public String telaCriacao(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("personagens", personagemService.getAll());
		model.addAttribute("equipes", equipeService.getAll(usuario));
		model.addAttribute("equipamentos", equipamentoService.getEquipamentosByOrderName(usuario));

		return "equipe/criacao";
	}

	@PostMapping(value = "/equipe/incluir")
	public String postEquipe(Model model, @RequestParam(required = false) String[] personagemId, Equipe equipe,
			@SessionAttribute("user") Usuario usuario) {

		String msg = null;
		try {
			List<Personagem> personagens = new ArrayList<Personagem>();
			for (String id : personagemId) {
				personagens.add(personagemService.getPersonagemById(Integer.valueOf(id)));
			}

			equipe.setPersonagens(personagens);
			equipe.setUsuario(usuario);
			equipeService.createEquipe(equipe);
			for (Personagem personagem : personagens) {
				personagem.setEquipe(equipeService.getEquipeById(equipe.getId()));
			}

			msg = "Equipe criada com sucesso.";
		} catch (Exception e) {
			msg = "Adicione um Personagem antes!!";
		}

		model.addAttribute("msg", msg);

		return listEquipe(model, usuario, equipe);
	}

	@GetMapping(value = "/equipe/{id}/excluir")
	public String deleteEquipe(Model model, @PathVariable int id) {

		String msg = null;
		try {
			equipeService.deleteEquipe(id);
			msg = "Equipe deletada com sucesso";
		} catch (Exception e) {
			msg = "Não foi possível deletar a equipe";
		}
		model.addAttribute("msg", msg);

		return "redirect:/equipe/lista";
	}

}
