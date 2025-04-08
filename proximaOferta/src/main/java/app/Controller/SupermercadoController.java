package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Supermercado;
import app.Service.SupermercadoService;

@RestController
@RequestMapping("/api/supermercado")
public class SupermercadoController {

	@Autowired
	private SupermercadoService supermercadoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(Supermercado supermercado){
		try {
			String message = this.supermercadoService.save(supermercado);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.supermercadoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Supermercado> findById(long id){
		try {
			Supermercado supermercado = this.supermercadoService.findById(id);
			return new ResponseEntity<>(supermercado, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Supermercado>> findAll(){
		try {
			List<Supermercado> list = this.supermercadoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(Supermercado supermercado, long id){
		try {
			String message = this.supermercadoService.update(supermercado, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
