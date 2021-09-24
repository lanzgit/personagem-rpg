package br.edu.infnet.services;

import java.util.List;

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

	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public List<Usuario> getAllByOrderName() {
		return usuarioRepository.findByOrderByNomeAsc();	
	}

	public void deleteUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id);
	}

	public Integer getUsuarioQntd() {
		return (int) usuarioRepository.count();
	}
}
