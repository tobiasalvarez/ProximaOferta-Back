package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Comprador;
import app.Repository.CompradorRepository;

@Service
public class CompradorService {

	@Autowired
	private CompradorRepository compradorRepository;
	
	public String save(Comprador comprador) {
		this.compradorRepository.save(comprador);
		return "Comprador Criado!!";
	}
	
	public String deleteById(long id) {
		this.compradorRepository.deleteById(id);
		return "Comprador deletado!";
	}
	
	public Comprador findById(long id) {
		Comprador comprador = this.compradorRepository.findById(id).get();
		return comprador;
	}
	
	public List<Comprador> findAll(){
		List<Comprador> list = this.compradorRepository.findAll();
		return list;
	}
	
	public String update(Comprador comprador, long id){
		comprador.setId(id);
		this.compradorRepository.save(comprador);
		return "Comprador atualizado";
	}
	
	 public List<Comprador> findByNomeContaining(String nome) {
	        return compradorRepository.findByNomeContainingIgnoreCase(nome);
	    }
}
