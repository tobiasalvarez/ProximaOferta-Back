package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Usuario;
import app.Repository.UsuarioRepositoy;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositoy usuarioRepositoy;
	
	public String save(Usuario usuario) {
		this.usuarioRepositoy.save(usuario);
		return "Usuario Criado!!";
	}
	
	public String deleteById(long id) {
		this.usuarioRepositoy.deleteById(id);
		return "Usuario Deletado!";
	}
	
	public Usuario findById(long id) {
		Usuario usuario = this.usuarioRepositoy.findById(id).get();
		return usuario;
	}
	
	public List<Usuario> findAll() {
		List<Usuario> list = this.usuarioRepositoy.findAll();
		return list;
	}
	
	public String update(Usuario usuario, long id) {
		usuario.setId(id);
		this.usuarioRepositoy.save(usuario);
		return "Usuario Atualizado!!";
	}
}
