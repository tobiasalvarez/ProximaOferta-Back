package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Comprador;
import app.Entity.Comprador;
import app.Entity.Sexo;

public interface SexoRepository extends JpaRepository<Sexo, Long>{
	
	List<Sexo> findByGeneroContainingIgnoreCase(String genero);
	
	List<Sexo> findByCompradorNomeContainingIgnoreCase(String nome);
	
	List<Comprador> findByGenero(Sexo genero);

}
