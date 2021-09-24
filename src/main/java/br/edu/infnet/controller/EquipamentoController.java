package br.edu.infnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import br.edu.infnet.model.domain.Equipamento;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.EquipamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class EquipamentoController {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping(value="equipamento/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("equipamentos", equipamentoService.getEquipamentosByOrderName(usuario));

		return "equipamento/lista";
	}

	@GetMapping(value="equipamento/{id}/excluir")
	public String excluirEquipamento(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Equipamento equipamentoToDelete = equipamentoService.getById(id);
		String msg = null;
		try {
			if (equipamentoToDelete.getPersonagem() != null) {
				msg = "nao foi possivel excluir o equipamento " + equipamentoToDelete.getNome();	
			} else {
				equipamentoService.deleteEquipamento(id);
				msg = "Equipamento excluido com sucesso";
			}
		} catch (Exception e) {
		}
		model.addAttribute("msg", msg);
		
		return telaLista(model, usuario);
	}
	
	
	
}
