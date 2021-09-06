package br.edu.infnet.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.model.domain.Usuario;

@Repository
@EnableJpaRepositories
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	public Usuario autenticacao(String email, String senha);
}
