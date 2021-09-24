package br.edu.infnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.data.IArmaRepository;
import br.edu.infnet.model.domain.Arma;

@Service
public class ArmaService {
	
	@Autowired
	private IArmaRepository armaRepository;

	public List<Arma> getAll() {
		return (List<Arma>) armaRepository.findAll();
	}

	public List<Arma> getArmasByUsuarioByOrder(Integer usuarioId) {
		return armaRepository.findByUsuarioIdOrderByNomeAsc(usuarioId);
		
	}

	public void addArma(Arma arma) {
		armaRepository.save(arma);
	}

	public void deleteArma(Integer id) {
		armaRepository.deleteById(id);
	}

	public Arma getById(Integer id) {
		return armaRepository.findById(id).orElse(null);
	}

	public Integer getArmaQntd() {
		return (int) armaRepository.count();	
	}
}
