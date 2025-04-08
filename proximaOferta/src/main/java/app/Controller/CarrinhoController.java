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

import app.Entity.Carrinho;
import app.Service.CarrinhoService;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(Carrinho carrinho){
		try {
			String message = this.carrinhoService.save(carrinho);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.carrinhoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Carrinho> findById(long id){
		try {
			Carrinho carrinho = this.carrinhoService.findById(id);
			return new ResponseEntity<>(carrinho, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Carrinho>> findAll(){
		try {
			List<Carrinho> list = this.carrinhoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(Carrinho carrinho, long id){
		try {
			String message = this.carrinhoService.update(carrinho, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
