package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
   
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	private long id;
	
	private String nome;
	
	private String rua;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties("supermercado")
	private Usuario usuario;
	
	
}
