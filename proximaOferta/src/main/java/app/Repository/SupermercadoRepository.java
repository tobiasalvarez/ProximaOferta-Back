package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Long>{
	
	List<Supermercado> findByEmailContainingIgnoreCase(String email);

	
	List<Supermercado> findByUsuarioUsuarioContainingIgnoreCase(String usuario);

}
