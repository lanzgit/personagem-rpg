package br.edu.infnet.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ArmaService;
import br.edu.infnet.services.ArmaduraService;
import br.edu.infnet.services.ConsumivelService;
import br.edu.infnet.services.EquipeService;
import br.edu.infnet.services.PersonagemService;
import br.edu.infnet.services.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PersonagemService personagemService;
	@Autowired
	private EquipeService equipeService;
	@Autowired
	private ArmaService armaService;
	@Autowired
	private ArmaduraService armaduraService;
	@Autowired
	private ConsumivelService consumivelService;

	@GetMapping(value = "/")
	public String telaHome() {
		return "index";
	}

	@GetMapping(value="/rpg")
	public String telaRpg(Model model) {

		Map<String, Integer> mapataTotal = new HashMap<String, Integer>();
		mapataTotal.put("Usuarios", usuarioService.getUsuarioQntd());
		mapataTotal.put("Personagens", personagemService.getPersonagemQntd());
		mapataTotal.put("Equipe", equipeService.getEquipeQntd());
		mapataTotal.put("Arma", armaService.getArmaQntd());
		mapataTotal.put("Armadura", armaduraService.getArmaduraQntd());
		mapataTotal.put("Consumivel", consumivelService.getConsumivelQntd());

		model.addAttribute("mapaTotal", mapataTotal);

		return "rpg";
	}
	
	  
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";	
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");

		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String login(
		Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario usuarioToLogin = usuarioService.authUsuario(email, senha);
		if (usuarioToLogin != null) {
			model.addAttribute("user", usuarioToLogin);
			return "index";
		} else {
			model.addAttribute("mensagem", "Autenticação inválida");
			return "login";
		}
	}
}
