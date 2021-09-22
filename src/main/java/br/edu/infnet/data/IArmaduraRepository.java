package br.edu.infnet.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Armadura;

@Repository
public interface IArmaduraRepository extends CrudRepository<Armadura, Integer> {
	
	@Query("from Armadura a where a.usuario.id = :userId")
	public List<Armadura> getArmaduraList(Integer userId);
}
