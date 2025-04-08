/*package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Comanda;
import app.Service.ComandaService;

@RestController
@RequestMapping("/api/comanda")
public class ComandaController {

	@Autowired
	private ComandaService comandaService;
	
	/*public ResponseEntity<String> save(@RequestBody Comanda comanda){
		try {
			String message = this.comandaService.save(comanda);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}    so pra testar 
	
	public ResponseEntity<String> deleteById(long id){
		try {
			String message = this.comandaService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Comanda> findById(long id){
		try {
			Comanda comanda = this.comandaService.findById(id);
			return new ResponseEntity<>(comanda, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<Comanda>> findAll(){
		try {
			List<Comanda> list = this.comandaService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> update(Comanda comanda, long id){
		try {
			String message = this.comandaService.update(comanda, id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}*/
