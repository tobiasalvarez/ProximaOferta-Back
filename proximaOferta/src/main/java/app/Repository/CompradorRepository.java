package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.Entity.Comprador;
import app.Entity.Sexo;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{
	
	List<Comprador> findByGenero(Sexo genero);
	
	List<Comprador> findByRuaContainingIgnoreCase(String rua);
	
	List<Comprador> findByNomeContainingIgnoreCase(String nome);

}
