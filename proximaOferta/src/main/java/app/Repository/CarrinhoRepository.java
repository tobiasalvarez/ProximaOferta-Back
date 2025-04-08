package app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Entity.Carrinho;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
  
}