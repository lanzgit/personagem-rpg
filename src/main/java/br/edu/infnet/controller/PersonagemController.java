package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.PersonagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PersonagemController {
	
	@Autowired
	private PersonagemService personagemService;

	@GetMapping(value="/personagem/lista")
	public String listPersonagem(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("lista", personagemService.getAll(usuario));

		return "personagem/lista";
	}

	@GetMapping(value="/personagem")
	public String index() {
		return "personagem/criacao";
	}

	@PostMapping(value="/personagem/incluir")
	public String postPersonagem(Model model, Personagem personagem, @SessionAttribute("user") Usuario usuario) {
		personagem.setUsuario(usuario);
		personagemService.createPersonagem(personagem);
		String msg = "O personagem " + personagem.getNome() + " foi cadastrado.";
		model.addAttribute("msg", msg);
		
		return listPersonagem(model, usuario);
	}

	@GetMapping(value="/personagem/{id}/excluir")
	public String deletePersonagem(Model model, @PathVariable Integer id) {
		personagemService.deletePersonagem(id);

		return "redirect:/personagem/lista";
	}
	
	
	
	
}
