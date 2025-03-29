package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
   
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
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
public class Supermercado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Nome obrigatorio!!")
	private String nome;
	
	@NotNull(message = "Rua obrigatoria!!")
	private String rua;
	
	@Email(message = "Email obrigatorio!!")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties("supermercado")
	private Usuario usuario;
	
	
}
