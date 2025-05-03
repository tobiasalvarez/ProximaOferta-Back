package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.Entity.Comprador;
import app.Repository.CompradorRepository;
import app.Service.CompradorService;



@SpringBootTest
public class CompradorServiceTest {
	
	@Autowired
	CompradorService compradorService;
	
	@Mock
	CompradorRepository compradorRepository;
	
	
	
	@Test
	@DisplayName("Teste Unitario com Mockito")
	void testCreate() {
		Comprador comprador = new Comprador();
		comprador.setId(1);
		comprador.setRua("aaaaaa");
		comprador.setNome("aaaa");
		comprador.setGenero(null);
		
		
		/*when(compradorRepository.save(comprador)).thenReturn(comprador);
		
		Comprador retorno = this.compradorService.save(comprador);
		
		assertEquals(1, retorno.getId());
		assertEquals("aaaa", retorno.getRua());
		assertEquals("abc@gmail.com", retorno.getNome());
		assertEquals("aaaaaa", retorno.getGenero());*/
		
	
	}

}