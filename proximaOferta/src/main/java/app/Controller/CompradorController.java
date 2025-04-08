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

import app.Entity.Comprador;
import app.Service.CompradorService;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController {
	
	@Autowired
	private CompradorService compradorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(Comprador comprador){
		try {
			String message = this.compradorService.save(comprador);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleById/{id}")
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.compradorService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Comprador> findById(long id){
		try {
			Comprador comprador = this.compradorService.findById(id);
			return new ResponseEntity<>(comprador, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Comprador>> findAll(){
		try {
			List<Comprador> list = this.compradorService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(Comprador comprador, long id){
		try {
			String message = this.compradorService.update(comprador, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
