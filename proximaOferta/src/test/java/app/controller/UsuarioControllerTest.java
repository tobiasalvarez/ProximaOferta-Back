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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.Controller.UsuarioController;
import app.Entity.Usuario;
import app.Repository.UsuarioRepository;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class UsuarioControllerTest {
	
	@Autowired
	UsuarioController usuarioController;
	
	@MockitoBean
	UsuarioRepository usuarioRepository;
	
	
	@BeforeEach
	void setup() {
		var auth = new UsernamePasswordAuthenticationToken(
		        "ADMIN",
		        null,
		        List.of(new SimpleGrantedAuthority("ADMIN"))
		    );
		SecurityContextHolder.getContext().setAuthentication(auth);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsuario("aaa");
		usuario.setSenha("aa");
		
		List<Usuario> list = new ArrayList<>();
		list.add(usuario);
		
		when(usuarioRepository.findAll()).thenReturn(list);
		when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));		
	}
	
	
	@Test
	@DisplayName("cenario 01 usuario test de int com mock")
	void cenario01() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsuario("aaa");
		usuario.setSenha("aa");
		
		
		when(usuarioRepository.save(usuario)).thenReturn(usuario);
		ResponseEntity<String> retorno = this.usuarioController.save(usuario);
		assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
		
	}
	
	@Test
	@DisplayName("cenario 02 usuario test de int com mock")
	void cenario02() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsuario(null);
		usuario.setSenha("aa");
		
		
		when(usuarioRepository.save(usuario)).thenReturn(usuario);
		assertThrows(ConstraintViolationException.class, () -> {
	        usuarioController.save(usuario);
	    });
		
	}
	
	@Test
	@DisplayName("cenario 03 usuario test de int com mock")
	void cenario03 () {
		doNothing().when(usuarioRepository).deleteById(1L);
		ResponseEntity<String> retorno = this.usuarioController.deleteById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	
	@Test
	@DisplayName("cenario 04 usuario test de int com mock")
	void cenario04 () {
		ResponseEntity<List<Usuario>> retorno = this.usuarioController.findAll();
		assertEquals(1, retorno.getBody().size());
	}
	
	@Test
	@DisplayName("cenario 05 usuario test de int com mock")
	void cenario05 () {
		ResponseEntity<Usuario> retorno = this.usuarioController.findById(1L);
		assertEquals("aaa", retorno.getBody().getUsuario());
	}
	
	@Test
	@DisplayName("cenario 06 usuario test de int com mock")
	void cenario06() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setUsuario("aaa");
		usuario.setSenha("aa");
		ResponseEntity<Usuario> retorno = this.usuarioController.update(usuario, 1L);
		assertEquals("aaa",retorno.getBody().getUsuario());
		
	}
	

}
