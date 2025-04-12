package app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Carrinho;
import app.Entity.ItemCarrinho;
import app.Entity.Produto;
import app.Repository.CarrinhoRepository;
import app.Repository.ProdutoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	//cria o carrinho
	public Carrinho getCarrinhoAtivo() {
        return carrinhoRepository.findFirstByFinalizadoFalse()
        		.orElseGet(() -> carrinhoRepository.save(new Carrinho()));
    
    }
	
	 //adiciona o item no carrinho
	public Carrinho adicionarProduto(Long produtoId, int quantidade) {
	    Carrinho carrinho = getCarrinhoAtivo();

	    Produto produto = produtoRepository.findById(produtoId)
	            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

	    boolean encontrado = false;

	    for (ItemCarrinho item : carrinho.getItens()) {
	        if (item.getProduto() != null && item.getProduto().getId().equals(produtoId)) {
	            item.setQuantidade(item.getQuantidade() + quantidade);
	            encontrado = true;
	            break;
	        }
	        
	        if (!encontrado) {
	            ItemCarrinho novo = new ItemCarrinho(produto, quantidade);
	            novo.setCarrinho(carrinho);
	            carrinho.getItens().add(novo);
	        }

	        return carrinhoRepository.save(carrinho);
	    }


	    if (!encontrado) {
	        ItemCarrinho novo = new ItemCarrinho(produto, quantidade);
	        novo.setProduto(produto);
	        novo.setQuantidade(quantidade);
	        novo.setCarrinho(carrinho);
	        carrinho.getItens().add(novo);
	    }

	    return carrinhoRepository.save(carrinho);
	}
	 
	 public Carrinho atualizarQuantidade(Long itemId, int novaQuantidade) {
		    Carrinho carrinho = getCarrinhoAtivo();

		    for (ItemCarrinho item : carrinho.getItens()) {
		        if (item.getId() == itemId) {
		            item.setQuantidade(novaQuantidade);
		            break;
		        }
		    }

		    return carrinhoRepository.save(carrinho);
		}
	 
	
	public String save(Carrinho carrinho) {
		this.carrinhoRepository.save(carrinho);
		return "carrinho Criado!!";
	}
	
	public String deleteById(long id) {
		this.carrinhoRepository.deleteById(id);
		return "Carrinho deletado!";
	}
	
	public Carrinho findById(long id) {
		Carrinho carrinho = this.carrinhoRepository.findById(id).get();
		return carrinho;
	}
	
	public List<Carrinho> findAll(){
		List<Carrinho> list = this.carrinhoRepository.findAll();
		return list;
	}
	
	public String update(Carrinho carrinho, long id){
		carrinho.setId(id);
		this.carrinhoRepository.save(carrinho);
		return "Carrinho atualizado";
	}

	public Carrinho removerItem(Long itemId) {
        Carrinho carrinho = getCarrinhoAtivo();
        carrinho.getItens().removeIf(i -> i.getId() == itemId);
        return carrinhoRepository.save(carrinho);
    }
}
