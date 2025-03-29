package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Comanda;
import app.Repository.ComandaRepository;

@Service
public class ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;
	
	public String save(Comanda comanda) {
		this.comandaRepository.save(comanda);
		return "Comanda Criada!!";
	}
	
	public String deleteById(long id) {
		this.comandaRepository.deleteById(id);
		return "Comanda deletada!";
	}
	
	public Comanda findById(long id) {
		Comanda comanda = this.comandaRepository.findById(id).get();
		return comanda;
	}
	
	public List<Comanda> findAll(){
		List<Comanda> list = this.comandaRepository.findAll();
		return list;
	}
	
	public String update(Comanda comanda, long id){
		comanda.setId(id);
		this.comandaRepository.save(comanda);
		return "Comanda atualizada";
	}
	
	
}
