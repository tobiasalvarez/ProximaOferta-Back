package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Nome obrigatorio!!")
	private String nome;
	@NotBlank(message = "Validade obrigatoria!")
	private String validade;
	@NotBlank(message = "Preco Original obrigatorio!!")
	private double precoOriginal;
	@NotBlank(message = "Preco Com Desconto obrigatorio!!")
	private double precoAtual;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	@JoinColumn(name = "Supermercado_id")
	private Supermercado supermercado;
	
	

}
