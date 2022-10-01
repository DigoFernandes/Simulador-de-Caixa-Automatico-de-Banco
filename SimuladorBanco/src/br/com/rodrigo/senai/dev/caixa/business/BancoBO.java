package br.com.rodrigo.senai.dev.caixa.business;

import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.senai.dev.caixa.domain.Usuario;
import br.com.rodrigo.senai.dev.caixa.exception.SaldoInsuficienteException;
import br.com.rodrigo.senai.dev.caixa.exception.ValorInvalidoException;

public class BancoBO {

	static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static void salvarUsuario(Usuario usuario) {

		usuarios.add(usuario);

	}

	public static List<Usuario> Listar() {

		return usuarios;

	}

	public static void removerUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}

	private static void verificarSaldo(int saldo, int verificacao) throws SaldoInsuficienteException {

		if ((saldo < verificacao || saldo <= 0))
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		{
		}

	}

	public static void sacar(Usuario usuario, int valor) throws SaldoInsuficienteException {

		verificarSaldo(usuario.getSaldo(), valor);

		usuario.setSaldo(usuario.getSaldo() - valor);

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

	public static void calculadorDeNotas() {

	}

}
