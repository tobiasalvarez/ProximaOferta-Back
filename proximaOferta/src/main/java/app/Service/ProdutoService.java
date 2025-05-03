package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Produto;
import app.Entity.Supermercado;
import app.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	public Produto save(Produto produto) {
		this.produtoRepository.save(produto);
		return produto;
	}
			
			
/*			throw new RuntimeException("Nao e possivel cadastrar um produto sem um supermercado associado.");
		} else {
			this.produtoRepository.save(produto);
			return "Produto Criado!!";
		}
}
	}
	*/
			
	public String deleteById(long id) {
		this.produtoRepository.deleteById(id);
		return "Produto deletado!";
	}
	
	public Produto findById(long id) {
		Produto produto = this.produtoRepository.findById(id).get();
		return produto;
	}
	
	public List<Produto> findAll(){
		List<Produto> list = this.produtoRepository.findAll();
		return list;
	}
	
	public String update(Produto produto, long id){
		produto.setId(id);
		this.produtoRepository.save(produto);
		return "Produto atualizado";
	}
	
	 public List<Produto> findByNomeContainingIgnoreCase(String nome) {
	        return produtoRepository.findByNomeContainingIgnoreCase(nome);
	    }
}
