package br.edu.infnet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.data.IPersonagemRepository;
import br.edu.infnet.model.domain.Equipe;
import br.edu.infnet.model.domain.Personagem;
import br.edu.infnet.model.domain.Usuario;

@Service
public class PersonagemService {
	
	@Autowired
	private IPersonagemRepository personagemRepository;

	public List<Personagem> getAll(Usuario usuario) {
		return personagemRepository.getAllByUserId(usuario.getId());
	}

	// public List<Personagem> getAllByEquipeId(Equipe equipe) {
	// 	return personagemRepository.getAllByEquipeId(equipe.getId());
		
	// }
	public List<Personagem> getAll() {
		return (List<Personagem>) personagemRepository.findAll();
	}

	public Personagem getPersonagemById(int id) {
		
		Personagem personagem = personagemRepository.findById(id);
		return personagem;
	}

	public void createPersonagem(Personagem personagem) {
		personagemRepository.save(personagem);
	}

	public void deletePersonagem(Integer id) {
		personagemRepository.deleteById(id);
	}
}
