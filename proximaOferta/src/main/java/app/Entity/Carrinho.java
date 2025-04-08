package app.Entity;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Scope("session") // se quiser manter carrinho por sessão
@Getter
@Setter
public class Carrinho {
    
	@Id
	@GeneratedValue
	private long id;
	
	 private boolean finalizado = false;

	 @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<ItemCarrinho> itens = new ArrayList<>();
	
}
