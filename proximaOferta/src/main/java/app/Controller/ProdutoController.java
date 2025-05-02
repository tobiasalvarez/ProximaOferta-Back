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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Comprador;
import app.Entity.Produto;
import app.Entity.Supermercado;
import app.Repository.ProdutoRepository;
import app.Service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    private ProdutoRepository produtoRepository;

    @PostMapping("/save")
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto){
			 this.produtoService.save(produto);
			return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}
	@DeleteMapping("/deleById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
			String message = this.produtoService.deleteById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
			Produto produto = this.produtoService.findById(id);
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Produto>> findAll(){
			List<Produto> list = this.produtoService.findAll();
			return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	@GetMapping("/produtos") // Para a busca por nome
	public List<Produto> listarProdutos(@RequestParam(required = false) String nome) {
	    if (nome != null) {
	        return produtoRepository.findByNomeContainingIgnoreCase(nome);
	    } else {
	        return produtoRepository.findAll();
	    }
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Produto> update(@Valid @RequestBody Produto produto,@PathVariable long id){
			this.produtoService.update(produto, id);
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	@GetMapping("/findByNomeContaining")
	public ResponseEntity<List<Produto>> findByNomeContaining(@RequestParam String nome) {
	    List<Produto> produtos = produtoService.findByNomeContaining(nome);
	    return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

}
