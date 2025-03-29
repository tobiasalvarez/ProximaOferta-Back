package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{

}
