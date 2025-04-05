package app.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Carrinho;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
	Optional<Carrinho> findFirstByFinalizadoFalse();
  
}
