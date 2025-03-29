package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Usuario;
import app.Service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	public ResponseEntity<String> save(Usuario usuario){
		try {
			String message = this.usuarioService.save(usuario);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.usuarioService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Usuario> findById(long id){
		try {
			Usuario usuario = this.usuarioService.findById(id);
			return new ResponseEntity<>(usuario, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<Usuario>> findAll(){
		try {
			List<Usuario> list = this.usuarioService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> update(Usuario usuario, long id){
		try {
			String message = this.usuarioService.update(usuario, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
