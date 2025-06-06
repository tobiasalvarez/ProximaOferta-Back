package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Supermercado;
import app.Service.SupermercadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supermercado")
@CrossOrigin("*")
@Validated
public class SupermercadoController {

	@Autowired
	private SupermercadoService supermercadoService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<Supermercado> save(@Valid @RequestBody Supermercado supermercado){
			 this.supermercadoService.save(supermercado);
			return new ResponseEntity<>(supermercado, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.supermercadoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/findById/{id}")
	public ResponseEntity<Supermercado> findById(@PathVariable long id){
			Supermercado supermercado = this.supermercadoService.findById(id);
			return new ResponseEntity<>(supermercado, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Supermercado>> findAll(){
			List<Supermercado> list = this.supermercadoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/update/{id}")
	public ResponseEntity<Supermercado> update(@Valid @RequestBody Supermercado supermercado,@PathVariable long id){
			this.supermercadoService.update(supermercado, id);
			return new ResponseEntity<>(supermercado, HttpStatus.OK);
	}
	
	@GetMapping("/findByEmailContainingIgnoreCase")
	public ResponseEntity<List<Supermercado>> findByEmailContainingIgnoreCase(@RequestParam String email){
		List<Supermercado> lista = this.supermercadoService.findByEmailContainingIgnoreCase(email);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByUsuarioUsuarioContainingIgnoreCase")
	public ResponseEntity<List<Supermercado>> findByUsuarioUsuarioContainingIgnoreCase(@RequestParam  String usuario){
		List<Supermercado> lista = this.supermercadoService.findByUsuarioUsuarioContainingIgnoreCase(usuario);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
