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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.Controller.ProdutoController;
import app.Entity.Produto;
import app.Entity.Supermercado;
import app.Repository.ProdutoRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class ProdutoControllerTest {
	
	@Autowired
	ProdutoController produtoController;
	
	
	@MockitoBean
	ProdutoRepository produtoRepository;
	
	
	@BeforeEach
	void setup() {
		var auth = new UsernamePasswordAuthenticationToken(
		        "ADMIN",
		        null,
		        List.of(new SimpleGrantedAuthority("ADMIN"))
		    );
		SecurityContextHolder.getContext().setAuthentication(auth);
		Produto produto1 = new Produto();
	    produto1.setId(1L);
		produto1.setNome("aa");
		produto1.setValidade("aa");
		produto1.setPrecoAtual(2);
		produto1.setPrecoOriginal(3);
		
		List<Produto> list = new ArrayList<>();
		list.add(produto1);
		
		
		doNothing().when(produtoRepository).deleteById(1L);
		when(produtoRepository.findAll()).thenReturn(list);
		when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1));
		when(produtoRepository.findAll()).thenReturn(list);
		when(produtoRepository.findByNomeContainingIgnoreCase("a")).thenReturn(list);
		
	}
	
	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void testeCreate() {
		Produto produto2 = new Produto();
		produto2.setNome("aaa");
		produto2.setValidade("bbba");
		produto2.setPrecoAtual(1);
		produto2.setPrecoOriginal(3);
		
		when(produtoRepository.save(produto2)).thenReturn(produto2);
		
		ResponseEntity<Produto> retorno = this.produtoController.save(produto2);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
	}	
	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void cenario() {
		
		ResponseEntity<Produto> retorno = this.produtoController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void findAll() {
		
		ResponseEntity<List<Produto>> retorno = this.produtoController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	
	
	
	@Test
	@DisplayName("03 Teste de Integracao com Mockito")
	void cenario03() {
		ResponseEntity<String> retorno = this.produtoController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void cenario04() {
		Produto produto2 = new Produto();
		produto2.setNome("aaa");
		produto2.setValidade("bbba");
		produto2.setPrecoAtual(1);
		produto2.setPrecoOriginal(3);
		ResponseEntity<Produto> retorno = this.produtoController.update(produto2, 1);
		assertEquals("aaa", retorno.getBody().getNome());
	}
	
	
	@Test
	@DisplayName("Deve lançar ConstraintViolationException ao salvar produto inválido")
	void salvarProdutoInvalido_deveLancarExcecao() {
	    Produto produtoInvalido = new Produto(); // todos os campos vazios ou nulos

	    when(produtoRepository.save(produtoInvalido))
	        .thenThrow(new ConstraintViolationException("Dados inválidos", null));

	    assertThrows(ConstraintViolationException.class, () -> {
	        produtoController.save(produtoInvalido);
	    });
	}
	
	

	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void testeFindById() {
		
		
		ResponseEntity<Produto> retorno = this.produtoController.findById(1);
		assertEquals(1, retorno.getBody().getId());
		
	}
	
	@Test
	@DisplayName("Deve lançar NoSuchElementException ao buscar produto inexistente")
	void findById_inexistente() {
	    when(produtoRepository.findById(999L)).thenReturn(Optional.empty());

	    NoSuchElementException retorno = assertThrows(
	        NoSuchElementException.class,
	        () -> produtoController.findById(999L)
	    );

	    assertEquals("No value present", retorno.getMessage());
	}
	
	@Test
	@DisplayName("01 Teste de Integracao com Mockito")
	void cenario01() {
		ResponseEntity<List<Produto>> retorno = this.produtoController.findByNomeContainingIgnoreCase("a");
		assertEquals("aa", retorno.getBody().get(0).getNome());
		
	}
 
}
