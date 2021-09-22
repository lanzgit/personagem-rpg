package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Arma;
import br.edu.infnet.model.domain.Armadura;
import br.edu.infnet.model.domain.Consumivel;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.ArmaService;
import br.edu.infnet.services.ArmaduraService;
import br.edu.infnet.services.ConsumivelService;
import br.edu.infnet.services.UsuarioService;

@Component
public class EquipamentoLoader implements ApplicationRunner {


	@Autowired
	private ArmaService armaService;
	@Autowired
	private ArmaduraService armaduraService;
	@Autowired
	private ConsumivelService consumivelService;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = usuarioService.getUsuarioById(1);

		Arma w1 = new Arma("Excalibur", 4, 10);
		w1.setMaterial("nobre");
		w1.setTipo("Espada");
		w1.setAtributos();
		w1.setUsuario(usuario);
		armaService.addArma(w1);

		Arma w2 = new Arma("Espada de Madeira", 1, 2);
		w2.setMaterial("madeira");
		w2.setTipo("Espada");
		w2.setAtributos();
		w2.setUsuario(usuario);
		armaService.addArma(w2);

		Armadura a1 = new Armadura("Capacete de Baseball", 1, 2);
		a1.setMaterial("plastico");
		a1.setTipo("helmo");
		a1.setAtributos();
		a1.setUsuario(usuario);
		armaduraService.addArmadura(a1);

		Consumivel c1 = new Consumivel("Poção de Cura", 2, 1);
		c1.setEfeito(true);
		c1.setStatus(2);
		c1.setQntUso(3);
		c1.setAtributos();
		consumivelService.addConsumivel(c1);
		
		Consumivel c2 = new Consumivel("Poção de Veneno", 3, 1);
		c2.setEfeito(false);
		c2.setStatus(3);
		c2.setQntUso(1);
		c2.setAtributos();
		consumivelService.addConsumivel(c2);

	}
}
