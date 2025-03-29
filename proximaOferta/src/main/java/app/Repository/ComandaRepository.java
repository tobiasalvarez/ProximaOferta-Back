package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.Entity.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{

}
