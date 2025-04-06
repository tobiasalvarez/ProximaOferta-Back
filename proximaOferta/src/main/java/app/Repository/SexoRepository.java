package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Sexo;

public interface SexoRepository extends JpaRepository<Sexo, Long>{
	
	public List<Sexo> findByGeneroIgnoreCaseContaing(String genero);
	
	public List<Sexo> findByCompradorNomeIgnoreCaseContaing(String nomeComprador);

}
