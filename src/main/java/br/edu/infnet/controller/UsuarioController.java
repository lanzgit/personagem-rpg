package br.edu.infnet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuario")
	public String loginScreen() {
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("lista", usuarioService.getAll());
		return "usuario/lista";
	}

	@PostMapping(value = "/usuario")
	public String createUsuario(Usuario usuario) {
		usuarioService.addUsuario(usuario);	
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String deleteUsuario(Model model, @PathVariable Integer id) {
		usuarioService.deleteUsuario(id);

		return "redirect:/usuario/lista";
	}
}
