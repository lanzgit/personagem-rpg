package br.edu.infnet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.edu.infnet.model.domain.Equipamento;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.EquipamentoService;
import br.edu.infnet.services.PersonagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonagemController {

	@Autowired
	private PersonagemService personagemService;

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping(value = "/personagem/lista")
	public String listPersonagem(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", personagemService.getAllByOrderName(usuario));

		return "personagem/lista";
	}

	@GetMapping(value = "/personagem")
	public String telaCriacao(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("equipamentos", equipamentoService.getEquipamentosByOrderName(usuario));

		return "personagem/criacao";
	}

	@GetMapping(value = "/ficha")
	public String telaFicha(Model model, @RequestParam Integer id, @SessionAttribute("user") Usuario usuario) {

		Personagem personagem = personagemService.getPersonagemById(id);
		model.addAttribute("personagem", personagem);
		model.addAttribute("equipamentos", equipamentoService.getAll());
		model.addAttribute("meusEquipamentos", equipamentoService.getEquipamentoByPersonagemId(id));

		return "personagem/ficha";
	}

	@PostMapping(value = "/personagem/incluir")
	public String postPersonagem(Model model, @RequestParam(required = false) String[] equipamentoId,
			Personagem personagem, @SessionAttribute("user") Usuario usuario) {

		String msg = null;
		try {
			List<Equipamento> equipamentos = new ArrayList<Equipamento>();
			for (String id : equipamentoId) {
				equipamentos.add(equipamentoService.getById(Integer.valueOf(id)));
			}

			personagem.setEquipamentos(equipamentos);
			personagem.setUsuario(usuario);
			personagemService.createPersonagem(personagem);
			for (Equipamento equipamento : equipamentos) {
				equipamento.setPersonagem(personagemService.getPersonagemById(personagem.getId()));
			}

			msg = "O personagem " + personagem.getNome() + " foi cadastrado.";
			if (equipamentoId == null) {
				msg = "O personagem precisa conter algum equipamento!";
			}
		} catch (Exception e) {
		}
		model.addAttribute("msg", msg);

		return listPersonagem(model, usuario);
	}

	@GetMapping(value = "/personagem/{id}/excluir")
	public String deletePersonagem(Model model, @SessionAttribute("user") Usuario usuario, @PathVariable Integer id) {

		Personagem personagem = personagemService.getPersonagemById(id);
		String msg = null;

		try {
			if (personagem.getEquipe() != null) {
				msg = "Não foi possível deletar esse Personagem";
			} else {
				personagemService.deletePersonagem(id);
				msg = "O Personagem " + personagem.getNome() + " foi deletedo com Sucesso!";
			}
		} catch (Exception e) {
		}

		model.addAttribute("msg", msg);

		return listPersonagem(model, usuario);
	}

}
