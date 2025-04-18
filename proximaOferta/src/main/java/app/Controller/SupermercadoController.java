package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Supermercado;
import app.Service.SupermercadoService;

@RestController
@RequestMapping("/api/supermercado")
@CrossOrigin("*")
public class SupermercadoController {

	@Autowired
	private SupermercadoService supermercadoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Supermercado supermercado){
			String message = this.supermercadoService.save(supermercado);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.supermercadoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
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
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Supermercado supermercado,@PathVariable long id){
			String message = this.supermercadoService.update(supermercado, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
