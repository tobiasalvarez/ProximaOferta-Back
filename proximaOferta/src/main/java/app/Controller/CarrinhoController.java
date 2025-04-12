package app.Controller;

import app.Entity.Carrinho;
import app.Service.CarrinhoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarProduto(@RequestBody Map<String, Object> body) {
        Long produtoId = ((Number) body.get("produtoId")).longValue();
        int quantidade = ((Number) body.get("quantidade")).intValue();
        return ResponseEntity.ok(carrinhoService.adicionarProduto(produtoId, quantidade));
    }

    @PutMapping("/atualizar/{itemId}")
    public ResponseEntity<?> atualizarItem(@PathVariable Long itemId, @RequestBody Map<String, Object> body) {
        int quantidade = ((Number) body.get("quantidade")).intValue();
        return ResponseEntity.ok(carrinhoService.atualizarQuantidade(itemId, quantidade));
    }

    @DeleteMapping("/remover/{itemId}")
    public ResponseEntity<?> removerItem(@PathVariable Long itemId) {
        return ResponseEntity.ok(carrinhoService.removerItem(itemId));
    }

    @GetMapping
    public ResponseEntity<?> visualizarCarrinho() {
        return ResponseEntity.ok(carrinhoService.getCarrinhoAtivo());
    }

    /*@PostMapping("/finalizar")
    public ResponseEntity<?> finalizarCarrinho() {
        Carrinho carrinho = carrinhoService.getCarrinhoAtivo();
        return ResponseEntity.ok(comandaService.gerarComandaDoCarrinho(carrinho));
    }*/
    
    
}
