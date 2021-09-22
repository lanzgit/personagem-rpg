package br.edu.infnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.data.IArmaduraRepository;
import br.edu.infnet.model.domain.Armadura;

@Service
public class ArmaduraService {

	@Autowired
	private IArmaduraRepository armaduraRepository;

	public List<Armadura> getAll() {
		return (List<Armadura>) armaduraRepository.findAll();
	}

	public void addArmadura(Armadura armadura) {
		armaduraRepository.save(armadura);
	}

	public void deleteArmadura(Integer id) {
		armaduraRepository.deleteById(id);
	}

	public Armadura getById(Integer id) {
		return armaduraRepository.findById(id).orElse(null);
	}
	
}
