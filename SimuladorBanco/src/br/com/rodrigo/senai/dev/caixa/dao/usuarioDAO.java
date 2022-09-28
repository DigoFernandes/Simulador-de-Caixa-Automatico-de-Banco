package br.com.rodrigo.senai.dev.caixa.dao;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {

	static List <Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public static void salvarUsuario(Usuario usuario){
		
		usuarios.add(usuario);
		
		
	}

	public static List<Usuario> Listar() {
		
		return usuarios;
		
	}

}