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
		Produto produto1 = new Produto();
		produto1.setNome("aa");
		produto1.setValidade("aa");
		produto1.setPrecoAtual(2);
		produto1.setPrecoOriginal(3);
		
		List<Produto> list = new ArrayList<>();
		list.add(produto1);
		
		
		when(produtoRepository.findByNomeContainingIgnoreCase("a")).thenReturn(list);
		doNothing().when(produtoRepository).deleteById(1L);
		when(produtoRepository.findAll()).thenReturn(list);
		when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1));
		when(produtoRepository.findAll()).thenReturn(list);
		when(produtoRepository.findByNomeContainingIgnoreCase("bc")).thenReturn(list);
		
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
	@DisplayName("Teste de Integracao com Mockito")
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
	@DisplayName("Deve retornar NOT_FOUND ao buscar produto inexistente")
	void findById_inexistente() {
	    // Simula que o produto com ID 999 não existe
	    when(produtoRepository.findById(999L)).thenReturn(Optional.empty());

	    ResponseEntity<Produto> resposta = produtoController.findById(999L);

	    assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
	}

	
 
}
