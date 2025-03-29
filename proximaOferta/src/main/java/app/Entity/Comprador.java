package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Comprador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Nome obrigatorio!")
	private String nome;
	@NotNull(message = "Rua obrigatoria!")
	private String rua;
	@NotNull(message = "Bairro obrigatorio!")
	private String bairro;
	
	private int idade;

	@ManyToOne
	@JoinColumn(name = "sexo")
	@JsonIgnoreProperties("compradores")
	private Sexo genero;
	
	@OneToOne
	@JoinColumn(name = "comanda_id")
	@JsonIgnoreProperties("comprador")
	private Comanda comanda;
	

}
