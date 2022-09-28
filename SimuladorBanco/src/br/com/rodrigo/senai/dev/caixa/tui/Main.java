package br.com.rodrigo.senai.dev.caixa.tui;

import br.com.rodrigo.senai.dev.caixa.dao.usuarioDAO;
import br.com.rodrigo.senai.dev.caixa.domain.RoleEnum;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("Rodrigo", 123, RoleEnum.ADMINISTRADOR);
		Usuario usuario2 = new Usuario("RLun", 1223, RoleEnum.ADMINISTRADOR);
		Usuario usuario3 = new Usuario("Rigo", 1423, RoleEnum.ADMINISTRADOR);
		Usuario usuario4 = new Usuario("drigo", 15223, RoleEnum.ADMINISTRADOR);
		Usuario usuario5 = new Usuario("gordo", 112323, RoleEnum.ADMINISTRADOR);
		
		System.out.println(usuario);
		
		usuarioDAO.salvarUsuario(usuario);
		usuarioDAO.salvarUsuario(usuario2);
		usuarioDAO.salvarUsuario(usuario3);
		usuarioDAO.salvarUsuario(usuario4);
		usuarioDAO.salvarUsuario(usuario5);
		
		System.out.println(usuarioDAO.Listar());
		
		
	}
	
}
