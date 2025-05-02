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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Sexo;
import app.Service.SexoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sexo")
@CrossOrigin("*")
@Validated
public class SexoController {

	@Autowired
	private SexoService sexoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Sexo sexo){
			String message = this.sexoService.save(sexo);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.sexoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Sexo> findById(@PathVariable long id){
			Sexo sexo = this.sexoService.findById(id);
			return new ResponseEntity<>(sexo, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Sexo>> findAll(){
			List<Sexo> list = this.sexoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid Sexo sexo,@PathVariable long id){
			String message = this.sexoService.update(sexo, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findByGeneroContainingIgnoreCase")
	public ResponseEntity<List<Sexo>> findByGeneroContainingIgnoreCase(@RequestParam String genero){
		List<Sexo> lista = this.sexoService.findByGeneroContainingIgnoreCase(genero);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByCompradorNomeContainingIgnoreCase")
	public ResponseEntity<List<Sexo>> findByCompradorNomeContainingIgnoreCase(@RequestParam String comprador){
		List<Sexo> lista = this.sexoService.findByCompradorNomeContainingIgnoreCase(comprador);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
