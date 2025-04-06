package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Supermercado;
import app.Repository.SupermercadoRepository;

@Service
public class SupermercadoService {
	
	@Autowired
	private SupermercadoRepository supermercadoRepository;
	
	public String save(Supermercado supermercado){
		if (supermercado.getRua() == null) {
			supermercado.setCadastroCompleto(false);
			this.supermercadoRepository.save(supermercado);
			return "Supermercado Criado!";
		} else {
			supermercado.setCadastroCompleto(true);
			this.supermercadoRepository.save(supermercado);
			return "Supermercado Criado!";
		}
	}
	
	public String deleteById(long id){
		this.supermercadoRepository.deleteById(id);
		return "Supermercado Deletado!!";
	}
	
	public Supermercado findById(long id) {
		Supermercado supermercado = this.supermercadoRepository.findById(id).get();
		return supermercado;
	}
	
	public List<Supermercado> findAll(){
		List<Supermercado> list = this.supermercadoRepository.findAll();
		return list;
	}
	
	public String update(Supermercado supermercado, long id) {
		supermercado.setId(id);
		this.supermercadoRepository.save(supermercado);
		return "Supermercado Atualizado!";
	}

}
