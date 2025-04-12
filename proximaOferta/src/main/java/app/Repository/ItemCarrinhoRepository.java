package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
}
