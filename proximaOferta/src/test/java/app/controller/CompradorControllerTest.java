package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import app.Entity.Sexo;
import app.Entity.Usuario;
import app.Repository.CompradorRepository;

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
	@DisplayName("Teste de Integracao com Mockito")
	void testeCreate() {
		Comprador comprador1 = new Comprador();
		comprador1.setId(1L);
		comprador1.setRua("aa");
		comprador1.setNome("AAAA");
		comprador1.setBairro("bbb");
		comprador1.setIdade(5);
		
		when(compradorRepository.save(comprador1)).thenReturn(comprador1);
		
		ResponseEntity<Comprador> retorno = this.compradorController.save(comprador1);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
	}
	

	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void testeFindById() {
		
		
		ResponseEntity<Comprador> retorno = this.compradorController.findById(1);
		assertEquals(1, retorno.getBody().getId());
		
	}
	

	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void findAll() {
		
		ResponseEntity<List<Comprador>> retorno = this.compradorController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	
	
	@Test
	@DisplayName("Teste de Integracao com Mockito")
	void cenario02() {
		ResponseEntity<String> retorno = this.compradorController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	
	@Test
	@DisplayName("Deve deletar um comprador com sucesso")
	void testeDeleteById() {
	    doNothing().when(compradorRepository).deleteById(1L);

	    ResponseEntity<String> resposta = compradorController.deleteById(1L);

	    assertEquals(HttpStatus.OK, resposta.getStatusCode());
	    assertEquals("Comprador deletado!", resposta.getBody());
	}

	@Test
	@DisplayName("Deve atualizar um comprador com sucesso")
	void testeUpdateComprador() {
	    // Mock do gênero
	    Sexo sexo = new Sexo();
	    sexo.setId(1L);
	    sexo.setTipo("Feminino");

	    // Mock do comprador existente
	    Comprador compradorExistente = new Comprador();
	    compradorExistente.setId(1L);
	    compradorExistente.setNome("Maria");
	    compradorExistente.setRua("Rua A");
	    compradorExistente.setBairro("Centro");
	    compradorExistente.setIdade(28);
	    compradorExistente.setGenero(sexo);

	    // Mock do comprador atualizado
	    Comprador compradorAtualizado = new Comprador();
	    compradorAtualizado.setId(1L);
	    compradorAtualizado.setNome("Maria Atualizada");
	    compradorAtualizado.setRua("Rua Nova");
	    compradorAtualizado.setBairro("Novo Bairro");
	    compradorAtualizado.setIdade(30);
	    compradorAtualizado.setGenero(sexo);

	    when(compradorRepository.findById(1L)).thenReturn(Optional.of(compradorExistente));
	    when(compradorRepository.save(compradorAtualizado)).thenReturn(compradorAtualizado);

	    ResponseEntity<Comprador> resposta = compradorController.update(compradorAtualizado, 1L);

	    assertEquals(HttpStatus.OK, resposta.getStatusCode());
	    assertEquals("Maria Atualizada", resposta.getBody().getNome());
	    assertEquals("Rua Nova", resposta.getBody().getRua());
	}

	
	
	}
	
	
	

	
	

	
	
	
 

