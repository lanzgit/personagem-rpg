package br.edu.infnet.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Personagem;

@Repository
public interface IPersonagemRepository extends CrudRepository<Personagem, Integer> {
	
	@Query("from Personagem p where p.usuario.id = :userId")
	public List<Personagem> getAllByUserId(Integer userId);

	// @Query("from Personagem p where p.equipe.id = :equipeId")
	// public List<Personagem> getAllByEquipeId(Integer equipeId);

	Personagem findById(int id);
}
