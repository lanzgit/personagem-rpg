package br.edu.infnet.data;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Consumivel;

@Repository
public interface IConsumivelRepository extends CrudRepository<Consumivel, Integer> {
	
	@Query("from Consumivel c where c.usuario.id = :userId")
	public List<Consumivel> getConsumivelList(Integer userId);

	List<Consumivel> findByUsuarioIdOrderByNomeAsc(Integer userId);
}
