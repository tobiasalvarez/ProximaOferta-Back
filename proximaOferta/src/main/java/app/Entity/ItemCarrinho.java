package app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "produto_id")
    private Produto produto;
	
	@ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;
    
    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public ItemCarrinho() {
    	
    }

  
}
