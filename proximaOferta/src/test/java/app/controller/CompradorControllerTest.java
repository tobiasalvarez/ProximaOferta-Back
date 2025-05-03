package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.Controller.CompradorController;
import app.Entity.Comprador;
import app.Entity.Usuario;
import app.Repository.CompradorRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class CompradorControllerTest {
	
	@Autowired
	CompradorController compradorController;
	
	
	@MockitoBean
	CompradorRepository compradorRepository;
	
	
	@BeforeEach
	void setup() {
		Comprador comprador1 = new Comprador();
		comprador1.setId(1);
		comprador1.setRua("aa");
		comprador1.setNome("AAAA");
		comprador1.setBairro("bbb");
		comprador1.setIdade(5);
		
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsuario("aaa");
		usuario.setSenha("AAAAAAAA");
		
		
		
		List<Comprador> list = new ArrayList<>();
		list.add(comprador1);
		
		
		when(compradorRepository.findByNomeContainingIgnoreCase("a")).thenReturn(list);
		doNothing().when(compradorRepository).deleteById(1L);
		when(compradorRepository.findAll()).thenReturn(list);
		when(compradorRepository.findById(1L)).thenReturn(Optional.of(comprador1));
		when(compradorRepository.findAll()).thenReturn(list);

		
	}
	
	
	@Test
	@DisplayName("01 Teste de Integracao com Mockito")
	void testeCreate() {
		Comprador comprador1 = new Comprador();
		comprador1.setId(1);
		comprador1.setRua("aa");
		comprador1.setNome("AAAA");
		comprador1.setBairro("bbb");
		comprador1.setIdade(5);
		
		when(compradorRepository.save(comprador1)).thenReturn(comprador1);
		
		ResponseEntity<Comprador> retorno = this.compradorController.save(comprador1);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
	}
	
	@Test
	@DisplayName("02 Teste de Integracao com Mockito")
	void testeCreateBad() {
		Comprador comprador = new Comprador();
		comprador.setId(1);
		comprador.setRua("aa");
		comprador.setNome(null);
		comprador.setBairro("bbb");
		comprador.setIdade(5);
		
		
		assertThrows(ConstraintViolationException.class, () -> {
	        compradorController.save(comprador);
	    });
	}
	
	@Test
	@DisplayName("03 Teste de Integracao com Mockito")
	void testeFindById() {
		
		
		ResponseEntity<Comprador> retorno = this.compradorController.findById(1);
		assertEquals(1, retorno.getBody().getId());
		
	}
	
	@Test
	@DisplayName("04 Teste de Integracao com Mockito")
	void cenario() {
		
		ResponseEntity<Comprador> retorno = this.compradorController.findById(1);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	@DisplayName("05 Teste de Integracao com Mockito")
	void findAll() {
		
		ResponseEntity<List<Comprador>> retorno = this.compradorController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	
	
	@Test
	@DisplayName("06 Teste de Integracao com Mockito")
	void cenario02() {
		ResponseEntity<String> retorno = this.compradorController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	@DisplayName("07 Teste de Integracao com Mockito")
	void cenario03() {
		Comprador comprador1 = new Comprador();
		comprador1.setId(1);
		comprador1.setRua("aa");
		comprador1.setNome("AAAA");
		comprador1.setBairro("bbb");
		comprador1.setIdade(5);
		ResponseEntity<Comprador> retorno = this.compradorController.update(comprador1, 0);
		assertEquals("AAAA", retorno.getBody().getNome());
	}

	
	@Test
	@DisplayName("08 Teste de Integracao com Mockito")
	void cenario05() {
		
		ResponseEntity<List<Comprador>> retorno = this.compradorController.findByNomeContaining("a");
		assertEquals("AAAA", retorno.getBody().get(0).getNome());
		}
		
	
	
	
	
	}
	
	
	

	
	

	
	
	
 

