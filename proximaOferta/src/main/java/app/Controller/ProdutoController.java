package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Produto;
import app.Service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	public ResponseEntity<String> save(Produto produto){
		try {
			String message = this.produtoService.save(produto);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.produtoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Produto> findById(long id){
		try {
			Produto produto = this.produtoService.findById(id);
			return new ResponseEntity<>(produto, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<Produto>> findAll(){
		try {
			List<Produto> list = this.produtoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> update(Produto produto, long id){
		try {
			String message = this.produtoService.update(produto, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
