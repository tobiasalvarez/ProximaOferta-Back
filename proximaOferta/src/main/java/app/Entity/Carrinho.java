package app.Entity;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;

@Entity
public class Carrinho {
    @Id @GeneratedValue
    private Long id;

    private boolean finalizado;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();


}

