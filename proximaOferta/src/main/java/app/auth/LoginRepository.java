package app.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Usuario;


public interface LoginRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsername(String login);
	
}
