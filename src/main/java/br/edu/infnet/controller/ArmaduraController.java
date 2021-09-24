package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.model.domain.Armadura;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ArmaduraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ArmaduraController {

	@Autowired
	private ArmaduraService armaduraService;

	@GetMapping(value = "/armadura/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", armaduraService.getArmadurasByUsuarioId(usuario.getId()));
		return "armadura/lista";
	}

	@GetMapping(value = "/armadura")
	public String telaCadastro() {
		return "armadura/criacao";
	}

	@PostMapping(value = "/armadura/incluir")
	public String incluir(Model model, @SessionAttribute("user") Usuario usuario, Armadura armadura) {

		armadura.calcDef();
		armadura.setUsuario(usuario);
		armaduraService.addArmadura(armadura);
		model.addAttribute("msg", "Armadura cadastrada com sucesso!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/armadura/{id}/excluir")
	public String excluir(Model model, @SessionAttribute("user") Usuario usuario, @PathVariable Integer id) {

		Armadura armadura = armaduraService.getById(id);
		String msg = null;
		if (armadura.getPersonagem() != null) {
			msg = "A Armadura não pode ser exclúida";
		} else {
			armaduraService.deleteArmadura(id);
			msg = "A armadura " + armadura.getNome() + " foi excluida!";
		}

		model.addAttribute("msg", msg);
		return telaLista(model, usuario);
	}

}
