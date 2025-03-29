package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Sexo;
import app.Service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoController {

	@Autowired
	private SexoService sexoService;
	
	public ResponseEntity<String> save(Sexo sexo){
		try {
			String message = this.sexoService.save(sexo);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.sexoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Sexo> findById(long id){
		try {
			Sexo sexo = this.sexoService.findById(id);
			return new ResponseEntity<>(sexo, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<Sexo>> findAll(){
		try {
			List<Sexo> list = this.sexoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> update(Sexo sexo, long id){
		try {
			String message = this.sexoService.update(sexo, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
