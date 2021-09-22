package br.edu.infnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.services.UsuarioService;

@Component
@Order(1)
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNome("Vinicius");
		usuario.setEmail("vinicius@gmail.com");
		usuario.setSenha("1234");
		usuario.setAdmin(true);

		usuarioService.addUsuario(usuario);
		System.out.println("Adm incluído");	
	}
}
