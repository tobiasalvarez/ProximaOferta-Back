package app.Entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinTable(name = "produtosComanda")
	@JsonIgnoreProperties("comanda")
	private List<Produto> produtos;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<ItemCarrinho> itens;
	
	@OneToOne
	@JsonIgnoreProperties("comanda")
	private Comprador comprador;
	
	private LocalDateTime dataCriacao;
	

}


