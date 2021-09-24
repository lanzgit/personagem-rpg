package br.edu.infnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.data.IEquipamentoRepository;
import br.edu.infnet.model.domain.Equipamento;
import br.edu.infnet.model.domain.Usuario;

@Service
public class EquipamentoService {

	@Autowired
	private IEquipamentoRepository equipamentoRepository;

	public List<Equipamento> getAll() {
		return (List<Equipamento>) equipamentoRepository.findAll();
	}

	public List<Equipamento> getEquipamentosByUsuarioId(Usuario usuario) {
		return equipamentoRepository.getEquipamentoList(usuario.getId());	
	}

	public List<Equipamento> getEquipamentoByPersonagemId(Integer personagemId) {
		return equipamentoRepository.findByPersonagemId(personagemId);	
	}

	public List<Equipamento> getEquipamentosByOrderName(Usuario usuario) {
		return equipamentoRepository.findByUsuarioIdOrderByNomeAsc(usuario.getId());
		
	}

	public void deleteEquipamento(Integer id) {
		equipamentoRepository.deleteById(id);
	}

	public Equipamento getById(Integer id) {
		return equipamentoRepository.findById(id).orElse(null);
	}

	public Integer getArmaQntd() {
		return (int) equipamentoRepository.count();
	}
}
