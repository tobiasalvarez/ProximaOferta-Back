package app.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrinho {
	
	@Id
	@GeneratedValue
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

  
}
