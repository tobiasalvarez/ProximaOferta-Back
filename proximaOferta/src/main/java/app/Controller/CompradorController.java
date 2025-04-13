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

import app.Entity.Comprador;
import app.Service.CompradorService;

@RestController
@RequestMapping("/api/comprador")
@CrossOrigin("*")
public class CompradorController {
	
	@Autowired
	private CompradorService compradorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Comprador comprador){
			String message = this.compradorService.save(comprador);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.compradorService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Comprador> findById(@PathVariable long id){
			Comprador comprador = this.compradorService.findById(id);
			return new ResponseEntity<>(comprador, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Comprador>> findAll(){
			List<Comprador> list = this.compradorService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Comprador comprador,@PathVariable long id){
			String message = this.compradorService.update(comprador, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
