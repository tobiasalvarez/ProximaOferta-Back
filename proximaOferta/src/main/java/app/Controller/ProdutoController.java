package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Produto;
import app.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepo;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepo.findAll();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return produtoRepo.save(produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoRepo.deleteById(id);
    }
}
