package br.edu.infnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.data.IEquipeRepository;
import br.edu.infnet.model.domain.Equipe;
import br.edu.infnet.model.domain.Usuario;

@Service
public class EquipeService {

	@Autowired
	private IEquipeRepository equipeRepository ;

	public List<Equipe> getAll(Usuario usuario) {
		return equipeRepository.getEquipeList(usuario.getId());
	}

	public List<Equipe> getAll() {
		return (List<Equipe>) equipeRepository.findAll();
	}

	public Equipe getEquipeById(int id) {

		Equipe equipe = equipeRepository.findById(id);
		return equipe;
	}

	public void createEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
	}

	public void deleteEquipe(Integer id) {
		equipeRepository.deleteById(id);
	}

	public Integer getEquipeQntd() {
		return (int) equipeRepository.count();	
	}

}
