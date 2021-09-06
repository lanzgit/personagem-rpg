package br.edu.infnet.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Arma;

@Repository
public interface IArmaRepository extends CrudRepository<Arma, Integer> {
	
}
