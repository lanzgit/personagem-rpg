package br.edu.infnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Equipe;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.EquipeService;
import br.edu.infnet.services.PersonagemService;
import br.edu.infnet.services.UsuarioService;

@Component
@Order(3)
public class EquipeLoader implements ApplicationRunner{

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PersonagemService personagemService;


	@Override
	public void run(ApplicationArguments args) throws Exception {


		Usuario usuario = new Usuario();
		usuario = usuarioService.getUsuarioById(1);

		List<Personagem> personagens = new ArrayList<>();
		personagens = personagemService.getAll();

		Equipe equipeUm = new Equipe("Primeira Equipe", "la la la la");
		equipeUm.setPersonagens(personagens);
		equipeUm.setUsuario(usuario);
		equipeService.createEquipe(equipeUm);
		for (Personagem personagem : personagens) {
			personagem.setEquipe(equipeService.getEquipeById(equipeUm.getId()));
			System.out.println(personagem.getEquipe().getId());
		}


		
	}
	
}
