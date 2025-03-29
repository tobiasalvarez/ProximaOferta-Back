package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Produto;
import app.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return "Produto Criado!!";
	}
	
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
}
