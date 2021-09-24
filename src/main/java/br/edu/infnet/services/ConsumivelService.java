package br.edu.infnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.data.IConsumivelRepository;
import br.edu.infnet.model.domain.Consumivel;
import br.edu.infnet.model.domain.Usuario;

@Service
public class ConsumivelService {
	
	@Autowired
	private IConsumivelRepository consumivelRepository;

	public List<Consumivel> getAllByUsuario(Usuario usuario) {
		
		return consumivelRepository.getConsumivelList(usuario.getId());
	}

	public List<Consumivel> getConsumiveisByUsuarioId(Integer usuarioId) {
		return consumivelRepository.findByUsuarioIdOrderByNomeAsc(usuarioId);	
	}

	public Consumivel getConsumivelById(Integer id) {
		return consumivelRepository.findById(id).orElse(null);
	}

	public List<Consumivel> getAll() {
		return (List<Consumivel>) consumivelRepository.findAll();
	}

	public void addConsumivel(Consumivel consumivel) {
		consumivelRepository.save(consumivel);
	}

	public void deleteConsumivel(Integer id) {
		consumivelRepository.deleteById(id);;
	}

	public Integer getConsumivelQntd() {
		return (int) consumivelRepository.count();	
	}
}
