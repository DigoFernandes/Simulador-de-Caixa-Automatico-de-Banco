package br.com.rodrigo.senai.dev.caixa.dao;

import br.com.rodrigo.senai.dev.caixa.domain.Nota;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

	static List<Usuario> usuarios = new ArrayList<Usuario>();
	static List<Nota> notas = new ArrayList<Nota>();
	
			
			

	public static void salvarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static List<Usuario> listarUsuarios() {
		return usuarios;
	}

	public static List<Nota> listarNotas() {
		return notas;
	}

	public static void addNota(Nota nota) {
		notas.add(nota);
	}

	public static void removerUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public static Usuario buscarUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome)) {
				return usuario;
			}
		}
		return null;

	}
}