package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Sexo;
import app.Repository.SexoRepository;

@Service
public class SexoService {

	@Autowired
	private SexoRepository sexoRepository;
	
	public String save(Sexo sexo) {
		this.sexoRepository.save(sexo);
		return "Genero Criado!!";
	}
	
	public String deleteById(long id) {
		this.sexoRepository.deleteById(id);
		return "Genero deletada!";
	}
	
	public Sexo findById(long id) {
		Sexo sexo = this.sexoRepository.findById(id).get();
		return sexo;
	}
	
	public List<Sexo> findAll(){
		List<Sexo> list = this.sexoRepository.findAll();
		return list;
	}
	
	public String update(Sexo sexo, long id){
		sexo.setId(id);
		this.sexoRepository.save(sexo);
		return "Genero atualizado";
	}
}
