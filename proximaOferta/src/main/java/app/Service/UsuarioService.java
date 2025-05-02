package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
