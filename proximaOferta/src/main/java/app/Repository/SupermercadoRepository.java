package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Long>{
	
	public List<Supermercado> findByEmailWithIgnoreCaseContaing(String email);
	
	public List<Supermercado> findByUsuarioIgnoreCaseConting(String usuario);

}
