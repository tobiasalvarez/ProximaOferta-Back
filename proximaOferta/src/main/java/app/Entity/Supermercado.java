package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
   
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Nome obrigatorio!!")
	private String nome;
	
	
	private String rua;
	
	@Email(message = "Email obrigatorio!!")
	@NotBlank(message = "Email Obrigatorio")
	private String email;
	
	private boolean cadastroCompleto;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties("supermercado")
	private Usuario usuario;
	
	
}
