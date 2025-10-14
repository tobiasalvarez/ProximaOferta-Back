package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Comprador;
import app.Service.CompradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comprador")
@CrossOrigin("*")
@Validated
public class CompradorController {
	
	@Autowired
	private CompradorService compradorService;
	
	@PostMapping("/save")
	public ResponseEntity<Comprador> save(@Valid @RequestBody Comprador comprador){
			 this.compradorService.save(comprador);
			return new ResponseEntity<>(comprador, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.compradorService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Comprador> findById(@PathVariable long id){
			Comprador comprador = this.compradorService.findById(id);
			return new ResponseEntity<>(comprador, HttpStatus.OK);
	}
	
	@GetMapping("/findByNomeContaining")
	public ResponseEntity<List<Comprador>> findByNomeContaining(@RequestParam String nome) {
	    List<Comprador> compradores = compradorService.findByNomeContaining(nome);
	    return new ResponseEntity<>(compradores, HttpStatus.OK);
	}

	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Comprador>> findAll(){
			List<Comprador> list = this.compradorService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Comprador> update(@Valid @RequestBody Comprador comprador,@PathVariable long id){
			this.compradorService.update(comprador, id);
			return new ResponseEntity<>(comprador, HttpStatus.OK);
	}
	
	@GetMapping("/findAll/{numPaginaAtual}") public ResponseEntity<Page<Comprador>> findAll(@PathVariable("numPaginaAtual") int numPaginaAtual){
		Page<Comprador> lista = this.compradorService.findAll(numPaginaAtual); 
		 return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
