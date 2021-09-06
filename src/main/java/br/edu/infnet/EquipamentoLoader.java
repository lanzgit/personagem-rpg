package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Arma;
import br.edu.infnet.services.ArmaService;

@Component
public class EquipamentoLoader implements ApplicationRunner {


	@Autowired
	private  ArmaService armaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Arma a1 = new Arma("Excalibur", 4, 10);
		a1.setMaterial("nobre");
		a1.setTipo("Espada");
		a1.setAtributos();
		armaService.addArma(a1);

		Arma a2 = new Arma("Espada de Madeira", 1, 2);
		a2.setMaterial("madeira");
		a2.setTipo("Espada");
		a2.setAtributos();
		armaService.addArma(a2);
		
	}
}
