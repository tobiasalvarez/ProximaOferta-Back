package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.Entity.Comanda;
import app.Entity.Comprador;
import app.Entity.Produto;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	
	public List<Comanda> findByProdutosIgnoreCaseContaing(String produto);
	
	public List<Comanda> findByCompradorNomeIgnoreCaseContaing(String nomeComprador);

}
