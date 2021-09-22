package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.PersonagemService;
import br.edu.infnet.services.UsuarioService;

@Component
@Order(2)
public class PersonagemLoader implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PersonagemService personagemService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario = usuarioService.getUsuarioById(1);
		
		Personagem playerUm = new Personagem("Player 1", "Humano", "Mago");
		playerUm.setUsuario(usuario);
		personagemService.createPersonagem(playerUm);

		Personagem playerDois = new Personagem("Player 2", "Orc", "Guerreiro");
		playerDois.setUsuario(usuario);
		personagemService.createPersonagem(playerDois);
	}


	
}
