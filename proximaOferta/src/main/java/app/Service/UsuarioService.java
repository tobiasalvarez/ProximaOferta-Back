package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import app.Entity.Supermercado;
import app.Entity.Usuario;
import app.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String save(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return "Usuario Criado!!";
	}
	
	public String deleteById(long id) {
		this.usuarioRepository.deleteById(id);
		return "Usuario Deletado!";
	}
	
	public Usuario findById(long id) {
		Usuario usuario = this.usuarioRepository.findById(id).get();
		return usuario;
	}
	
	public List<Usuario> findAll() {
		List<Usuario> list = this.usuarioRepository.findAll();
		return list;
	}
	
	public Usuario update(Usuario usuario, long id) {
		usuario.setId(id);
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Page<Usuario> findAll(int numPaginaAtual){
		 int totalPorPagina = 2;
		 PageRequest pageRequest = PageRequest.of(numPaginaAtual-1, totalPorPagina);
		 return this.usuarioRepository.findAll(pageRequest);
	 }
}
