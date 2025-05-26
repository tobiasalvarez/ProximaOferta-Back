package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.Controller.SexoController;
import app.Entity.Comprador;
import app.Entity.Sexo;
import app.Repository.SexoRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class SexoControllerTest {
	
	@Autowired
	SexoController sexoController;
	
	@MockitoBean
	SexoRepository sexoRepository;
	
	@BeforeEach
	void setup () {
		var auth = new UsernamePasswordAuthenticationToken(
		        "ADMIN",
		        null,
		        List.of(new SimpleGrantedAuthority("ADMIN"))
		    );
		SecurityContextHolder.getContext().setAuthentication(auth);
		Sexo sexo = new Sexo();
		sexo.setId(1);
		sexo.setGenero("aaa");
		
		List<Sexo> list = new ArrayList<>();
		list.add(sexo);
		
		Comprador comprador = new Comprador();
		comprador.setId(1);
		comprador.setNome("aaa");
		sexo.setComprador(comprador);
		
		
		when(sexoRepository.findById(1L)).thenReturn(Optional.of(sexo));
		when(sexoRepository.findAll()).thenReturn(list);
		when(sexoRepository.findByGeneroContainingIgnoreCase("a")).thenReturn(list);
		when(sexoRepository.findByCompradorNomeContainingIgnoreCase("a")).thenReturn(list);
	}
	
	@Test
	void cenario01() {
		Sexo sexo = new Sexo();
		sexo.setId(1);
		sexo.setGenero("aaa");
		
		when(sexoRepository.save(sexo)).thenReturn(sexo);
		ResponseEntity<String> retorno = this.sexoController.save(sexo);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
	}
	
	@Test
	void cenario02() {
		Sexo sexo = new Sexo();
		sexo.setId(1);
		sexo.setGenero(null);
		
		when(sexoRepository.save(sexo)).thenReturn(sexo);
		assertThrows(ConstraintViolationException.class, () -> {
	        sexoController.save(sexo);
	    });
	}
	
	@Test
	void cenario03() {
		doNothing().when(sexoRepository).deleteById(1L);
		ResponseEntity<String> retorno = this.sexoController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	void cenario04() {
		ResponseEntity<Sexo> retorno = this.sexoController.findById(1L);
		assertEquals("aaa", retorno.getBody().getGenero());
	}
	
	@Test
	void cenario05() {
		when(sexoRepository.findById(-1L)).thenReturn(Optional.empty());
		assertThrows(NoSuchElementException.class, () -> {
	        sexoController.findById(-1L);
	    });
	}
	
	@Test
	void cenario06() {
		ResponseEntity<List<Sexo>> retorno = this.sexoController.findAll();
		assertEquals(1, retorno.getBody().size());
	}
	
	@Test
	void cenario07() {
		Sexo sexo = new Sexo();
		sexo.setId(1);
		sexo.setGenero("aaa");
		ResponseEntity<String> retorno = this.sexoController.update(sexo, 1);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	void cenario08() {
		ResponseEntity<List<Sexo>> retorno = this.sexoController.findByGeneroContainingIgnoreCase("a");
		assertEquals("aaa", retorno.getBody().get(0).getGenero());
	}
	
	@Test
	void cenario09() {
		ResponseEntity<List<Sexo>> retorno = this.sexoController.findByCompradorNomeContainingIgnoreCase("a");
		assertEquals("aaa", retorno.getBody().get(0).getComprador().getNome());
	}
	

}
