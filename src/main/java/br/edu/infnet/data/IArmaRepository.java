package br.edu.infnet.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Arma;

@Repository
public interface IArmaRepository extends CrudRepository<Arma, Integer> {
	
	@Query("from Arma a where a.usuario.id = :userId")
	public List<Arma> getArmaList(Integer userId);
}
