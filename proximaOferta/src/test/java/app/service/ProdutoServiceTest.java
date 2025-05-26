package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import app.Entity.Produto;
import app.Repository.ProdutoRepository;
import app.Service.ProdutoService;



@SpringBootTest
public class ProdutoServiceTest {
	
	@Autowired
	ProdutoService produtoService;
	
	@Mock
	ProdutoRepository produtoRepository;
	
	
	
	@Test
	@DisplayName("Teste Unitario com Mockito")
	void testCreate() {
		var auth = new UsernamePasswordAuthenticationToken(
		        "ADMIN",
		        null,
		        List.of(new SimpleGrantedAuthority("ADMIN"))
		    );
		SecurityContextHolder.getContext().setAuthentication(auth);
		Produto produto = new Produto();
		produto.setNome("aa");
		produto.setValidade("aa");
		produto.setPrecoAtual(2);
		produto.setPrecoOriginal(3);
		
		
		when(produtoRepository.save(produto)).thenReturn(produto);
		/*
		Produto retorno = this.produtoService.save(produto);
		
		assertEquals("aaaa", retorno.getValidade());
		assertEquals("abc@gmail.com", retorno.getPrecoAtual());
		assertEquals("aaaaaa", retorno.getPrecoOriginal());
		
	*/
	}

}