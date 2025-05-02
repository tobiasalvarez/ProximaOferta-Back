package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.Controller.SupermercadoController;
import app.Entity.Supermercado;
import app.Repository.SupermercadoRepository;
import app.Service.SupermercadoService;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class SupermercadoControllerTest {
	
	@Autowired
	SupermercadoController supermercadoController;
	
	
	@MockitoBean
	SupermercadoRepository supermercadoRepository;
	
	
	@BeforeEach
	void setup() {
		Supermercado supermercado1 = new Supermercado();
		supermercado1.setId(1);
		supermercado1.setNome("aa");
		supermercado1.setEmail("bc@gmail.com");
		supermercado1.setRua("bbb");
		
		
		List<Supermercado> list = new ArrayList<>();
		list.add(supermercado1);
		
		doNothing().when(supermercadoRepository).deleteById(1L);
		when(supermercadoRepository.findAll()).thenReturn(list);
		when(supermercadoRepository.findById(1L)).thenReturn(Optional.of(supermercado1));
		when(supermercadoRepository.findAll()).thenReturn(list);
		when(supermercadoRepository.findByEmailContainingIgnoreCase("bc")).thenReturn(list);
		
	}
	
	
	@Test
	void testeCreate() {
		Supermercado supermercado2 = new Supermercado();
		supermercado2.setId(2);
		supermercado2.setNome("aaa");
		supermercado2.setEmail("abc@gmail.com");
		supermercado2.setRua("bbba");
		
		when(supermercadoRepository.save(supermercado2)).thenReturn(supermercado2);
		
		ResponseEntity<Supermercado> retorno = this.supermercadoController.save(supermercado2);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
	}
	
	@Test
	void testeCreateBad() {
		Supermercado supermercado = new Supermercado();
		supermercado.setId(1);
		supermercado.setNome(null);
		supermercado.setEmail("abc@gmail.com");
		supermercado.setRua("aaaaaa");
		
		assertThrows(ConstraintViolationException.class, () -> {
	        supermercadoController.save(supermercado);
	    });
	}
	
	@Test
	void testeFindById() {
		
		
		ResponseEntity<Supermercado> retorno = this.supermercadoController.findById(1);
		assertEquals(1, retorno.getBody().getId());
		
	}
	
	@Test
	void cenario() {
		
		ResponseEntity<Supermercado> retorno = this.supermercadoController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	void findAll() {
		
		ResponseEntity<List<Supermercado>> retorno = this.supermercadoController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	
	@Test
	void cenario02() {
		
		ResponseEntity<List<Supermercado>> retorno = this.supermercadoController.findByEmailContainingIgnoreCase("bc");
		assertEquals("aa", retorno.getBody().get(0).getNome());
		
	}
	
	@Test
	void cenario03() {
		ResponseEntity<String> retorno = this.supermercadoController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	void cenario04() {
		Supermercado supermercado = new Supermercado();
		supermercado.setId(1);
		supermercado.setNome("aaa");
		supermercado.setEmail("abc@gmail.com");
		supermercado.setRua("aaaaaa");
		ResponseEntity<Supermercado> retorno = this.supermercadoController.update(supermercado, 1L);
		assertEquals("aaa", retorno.getBody().getNome());
	}
	
	
	@Test
	void cenario05() {
		
	}
	
	

	
	
	
 
}
