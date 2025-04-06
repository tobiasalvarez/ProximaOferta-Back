package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Comprador;
import app.Entity.Sexo;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{
	
	public List<Comprador> findByGeneroWith(String genero);
	
	public List<Comprador> findByRuaWithIgnoreCaseContaing(String rua);

}
