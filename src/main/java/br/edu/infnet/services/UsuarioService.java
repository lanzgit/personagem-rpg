package br.edu.infnet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.data.IUsuarioRepository;
import br.edu.infnet.model.domain.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	public Usuario authUsuario(String email, String senha) {
		return usuarioRepository.autenticacao(email, senha);
	}

	public void addUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
