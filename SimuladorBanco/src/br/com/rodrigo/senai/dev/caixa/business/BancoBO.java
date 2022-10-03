package br.com.rodrigo.senai.dev.caixa.business;

import java.util.List;
import br.com.rodrigo.senai.dev.caixa.dao.BancoDAO;
import br.com.rodrigo.senai.dev.caixa.domain.Nota;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;
import br.com.rodrigo.senai.dev.caixa.exception.SaldoInsuficienteException;
import br.com.rodrigo.senai.dev.caixa.exception.ValorInvalidoException;

public class BancoBO {

	private static boolean saqueValido(int valor){
		if(valor<=1640) {
			return true;
		}return false;
	}
	
	public static void salvarUsuario(Usuario usuario) {
		
		if(usuarioExiste(usuario)==false) {
		BancoDAO.salvarUsuario(usuario);
		System.out.println("Usuario adicionado com sucesso!");
	}else {
		System.out.println("O usuario já existe!");
	}
	}
	
	private static boolean usuarioExiste(Usuario usuario) {
		List <Usuario> usuarios = BancoDAO.listarUsuarios();
		
			if (usuarios.contains(usuario)) {
				return true;
			}
		
		return false;

	}
	
	public static List<Usuario> Listar() {

		return BancoDAO.listarUsuarios();

	}

	public static void removerUsuario(Usuario usuario) {
		BancoDAO.removerUsuario(usuario);
	}

	private static void verificarSaldo(int saldo, int verificacao) throws SaldoInsuficienteException {

		if ((saldo < verificacao || saldo <= 0))
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		{
		}

	}

	public static void sacar(Usuario usuario, Nota nota, int valor) throws SaldoInsuficienteException, ValorInvalidoException {
	
		int cont50=0, cont20=0,cont10=0,cont2=0;
		verificarSaldo(usuario.getSaldo(), valor);
		
		if(saqueValido(valor)) {
		while(valor != 0) {
			if(nota.getCinquenta() > 0) {
				valor -= 50; 
				nota.setCinquenta(nota.getCinquenta()-50);
				cont50++;
				nota.setCont50(cont50);
			}else if(nota.getVinte()>0) {
				valor -= 20; 
				nota.setVinte(nota.getVinte()-20);
				cont20++;
				nota.setCont20(cont20);
			}else if(nota.getDez()>0) {
				valor -= 10; 
				nota.setDez(nota.getDez()-10);
				cont10++;
				nota.setCont10(cont10);
			}else {
				valor -= 2; 
				nota.setDois(nota.getDois()-2);
				cont2++;
				nota.setCont2(cont2);
			}
		
		}
		usuario.setSaldo(usuario.getSaldo() - valor);
		}else {
			System.out.println("Insira um valor abaixo de 1640, o caixa possui poucas notas no momento");
		}
	}

	public static void depositar(Usuario usuario, int valor) throws ValorInvalidoException {

		verificarDeposito(valor);

		usuario.setSaldo(usuario.getSaldo() + valor);
	}

	private static void verificarDeposito(int valor) throws ValorInvalidoException {

		// "!" nega o valor

		if (!(valor > 0))
			throw new ValorInvalidoException("Valor Invalido!");
		{

		}

	}
		
		
	public static Usuario logar(String nome, String senha) {
		List<Usuario> usuarios = BancoDAO.listarUsuarios();
		for(Usuario usuario : usuarios) {
			if(usuario.getNome().equals(nome)&&usuario != null && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}