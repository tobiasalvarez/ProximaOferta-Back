package app.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Carrinho;


public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    Optional<Carrinho> findFirstByFinalizadoFalse();
}