package br.edu.infnet.controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuario")
	public String loginScreen() {
		return "cadastro";
	}

	@PostMapping(value = "/usuario")
	public String createUsuario(Usuario usuario) {
		usuarioService.addUsuario(usuario);	
		return "redirect:/";
	}
}
