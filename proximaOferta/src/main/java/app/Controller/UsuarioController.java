package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Usuario;
import app.Service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
@Validated
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid Usuario usuario){
			String message = this.usuarioService.save(usuario);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.usuarioService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id){
			Usuario usuario = this.usuarioService.findById(id);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Usuario>> findAll(){
			List<Usuario> list = this.usuarioService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Usuario> update(@RequestBody @Valid Usuario usuario,@PathVariable long id){
			Usuario user = this.usuarioService.update(usuario, id);
			return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
