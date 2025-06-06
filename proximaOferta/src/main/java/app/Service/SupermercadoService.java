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
	
	public Supermercado save(Supermercado supermercado) {
		this.supermercadoRepository.save(supermercado);
		return supermercado;
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
	
	public Supermercado update(Supermercado supermercado, long id) {
		supermercado.setId(id);
		this.supermercadoRepository.save(supermercado);
		return supermercado;
	}
	
	public List<Supermercado> findByEmailContainingIgnoreCase(String email){
		List<Supermercado> lista = this.supermercadoRepository.findByEmailContainingIgnoreCase(email);
		return lista;
	}
	
	public List<Supermercado> findByUsuarioUsuarioContainingIgnoreCase(String usuario){
		List<Supermercado> lista = this.supermercadoRepository.findByUsuarioUsuarioContainingIgnoreCase(usuario);
		return lista;
	}

}
