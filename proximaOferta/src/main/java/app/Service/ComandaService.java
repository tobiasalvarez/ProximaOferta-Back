/*package app.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Carrinho;
import app.Entity.Comanda;
import app.Entity.ItemCarrinho;
import app.Repository.ComandaRepository;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private CarrinhoRepoCarriitory carrinhoRepository;

    public Comanda criarComandaDoCarrinho() {
        Carrinho carrinho = carrinhoRepository.findFirstByFinalizadoFalse()
            .orElseThrow(() -> new RuntimeException("Nenhum carrinho ativo"));

        carrinho.setFinalizado(true);
        carrinhoRepository.save(carrinho);

        Comanda comanda = new Comanda();
        comanda.setDataCriacao(LocalDateTime.now());

        // Adicionar os itens do carrinho na comanda
        comanda.setItens(new ArrayList<>(carrinho.getItens()));

        return comandaRepository.save(comanda);
    }

    public String deleteById(long id) {
        this.comandaRepository.deleteById(id);
        return "Comanda deletada!";
    }

    public Comanda findById(long id) {
        return this.comandaRepository.findById(id).orElse(null);
    }

    public List<Comanda> findAll(){
        return this.comandaRepository.findAll();
    }

    public String update(Comanda comanda, long id){
        comanda.setId(id);
        this.comandaRepository.save(comanda);
        return "Comanda atualizada";
    }
}*/


