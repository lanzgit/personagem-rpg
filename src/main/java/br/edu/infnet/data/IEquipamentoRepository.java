package br.edu.infnet.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Equipamento;

@Repository
public interface IEquipamentoRepository extends CrudRepository<Equipamento, Integer> {
	
	@Query("from Equipamento e where e.usuario.id = :userId")
	public List<Equipamento> getEquipamentoList(Integer userId);
}
