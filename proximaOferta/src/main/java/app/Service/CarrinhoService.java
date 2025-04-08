package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Carrinho;
import app.Repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
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
}
