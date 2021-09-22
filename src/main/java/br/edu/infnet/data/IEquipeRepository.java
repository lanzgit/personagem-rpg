package br.edu.infnet.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Equipe;

@Repository
public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {

	@Query("from Equipe e where e.usuario.id = :userId ")
	public List<Equipe> getEquipeList(Integer userId);

	Equipe findById(int id);
	
}
