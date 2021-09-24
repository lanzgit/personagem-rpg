package br.edu.infnet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.model.domain.Equipamento;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ArmaService;
import br.edu.infnet.services.ArmaduraService;
import br.edu.infnet.services.ConsumivelService;
import br.edu.infnet.services.PersonagemService;
import br.edu.infnet.services.UsuarioService;

@Component
@Order(3)
public class PersonagemLoader implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ArmaService armaService;
	@Autowired
	private ArmaduraService armaduraService;
	@Autowired
	private ConsumivelService consumivelService;
	@Autowired
	private PersonagemService personagemService;

	@Override
	public void run(ApplicationArguments args) throws Exception {


		Usuario usuario = new Usuario();
		usuario = usuarioService.getUsuarioById(1);

		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		equipamentos.add(armaService.getById(1));
		equipamentos.add(armaduraService.getById(3));
		equipamentos.add(consumivelService.getConsumivelById(4));
		
		Personagem playerUm = new Personagem("Player 1", "Humano", "Mago");
		playerUm.setUsuario(usuario);
		playerUm.setEquipamentos(equipamentos);
		personagemService.createPersonagem(playerUm);

		Personagem playerDois = new Personagem("Player 2", "Orc", "Guerreiro");
		playerDois.setUsuario(usuario);
		personagemService.createPersonagem(playerDois);
	}


	
}
