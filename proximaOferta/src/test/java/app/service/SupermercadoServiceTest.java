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

import app.Entity.Supermercado;
import app.Repository.SupermercadoRepository;
import app.Service.SupermercadoService;

@SpringBootTest
public class SupermercadoServiceTest {
	
	@Autowired
	SupermercadoService supermercadoService;
	
	@Mock
	SupermercadoRepository supermercadoRepository;
	
	
	
	@Test
	@DisplayName("Teste Unitario com Mockito")
	void testCreate() {
		var auth = new UsernamePasswordAuthenticationToken(
		        "ADMIN",
		        null,
		        List.of(new SimpleGrantedAuthority("ADMIN"))
		    );
		SecurityContextHolder.getContext().setAuthentication(auth);
		Supermercado supermercado = new Supermercado();
		supermercado.setId(1);
		supermercado.setNome("aaaa");
		supermercado.setEmail("abc@gmail.com");
		supermercado.setRua("aaaaaa");
		
		when(supermercadoRepository.save(supermercado)).thenReturn(supermercado);
		
		Supermercado retorno = this.supermercadoService.save(supermercado);
		
		
		assertEquals(1, retorno.getId());
		assertEquals("aaaa", retorno.getNome());
		assertEquals("abc@gmail.com", retorno.getEmail());
		assertEquals("aaaaaa", retorno.getRua());
		
	
	}

}
