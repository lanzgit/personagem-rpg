package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.model.domain.Arma;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ArmaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ArmaController {

	@Autowired
	private ArmaService armaService;

	@GetMapping(value = "/arma/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", armaService.getArmasByUsuarioByOrder(usuario.getId()));
		return "arma/lista";
	}

	@GetMapping(value = "/arma")
	public String telaCadastro() {
		return "arma/criacao";
	}

	@PostMapping(value = "/arma/incluir")
	public String incluir(Model model, @SessionAttribute("user") Usuario usuario, Arma arma) {

		arma.calcDano();
		arma.setUsuario(usuario);
		armaService.addArma(arma);
		model.addAttribute("msg", "Arma cadastrada com sucesso!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/arma/{id}/excluir")
	public String excluir(Model model, @SessionAttribute("user") Usuario usuario, @PathVariable Integer id) {

		Arma arma = armaService.getById(id);
		String msg = null;
		try {
			if (arma.getPersonagem() != null) {
				msg = "Não foi possível excluir essa Arma!";
			} else {
				armaService.deleteArma(id);
				msg = "A " + arma.getNome() + " foi excluida!";
			}

		} catch (Exception e) {
		}
		model.addAttribute("msg", msg);

		return telaLista(model, usuario);
	}

}
