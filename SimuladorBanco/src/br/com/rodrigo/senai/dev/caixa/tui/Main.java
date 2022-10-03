package br.com.rodrigo.senai.dev.caixa.tui;

import java.util.Scanner;
import br.com.rodrigo.senai.dev.caixa.business.BancoBO;
import br.com.rodrigo.senai.dev.caixa.domain.RoleEnum;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;
import br.com.rodrigo.senai.dev.caixa.exception.SaldoInsuficienteException;
import br.com.rodrigo.senai.dev.caixa.exception.ValorInvalidoException;

public class Main {

	public static void main(String[] args) {

		try {
			Start();
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	private static void Start() throws ValorInvalidoException, SaldoInsuficienteException {

		Scanner sc = new Scanner(System.in);

		Usuario ADM = new Usuario("ADM", "12345", RoleEnum.ADMINISTRADOR);
		BancoBO.salvarUsuario(ADM);
		int aux = 0,numero = 0;
		do {
			System.out.println("Olá, bem vindo ao caixa tenditudo");
			System.out.println("Você já possui um login? Digite 1 para Sim ou digite qualquer numero para Não");
			numero = sc.nextInt();
			menuPrincipal(sc,numero);
			System.out.println("Deseja Continuar? Digite 1");
			aux = sc.nextInt();
		} while (aux == 1);
		

	}

	private static void menuPrincipal(Scanner sc, int numero) {
		
		switch (numero) {
		case 1: {
			logar(sc);
			break;
		}
		case 2: {
			cadastrarUsuario(sc);
			break;
		}
		case 3: {
			
			break;
		}
		default:
			System.out.println("Opção Invállida, tente novamente!");
			System.out.println("Você já possui um login? Digite 1 para Sim ou digite qualquer numero para Não");
			numero = sc.nextInt();
			menuPrincipal(sc, numero);
		}
	}

	private static void logar(Scanner sc) {

		System.out.println("Insira seu login:");
		sc.nextLine();
		String login = sc.nextLine();

		System.out.println("Insira sua senha:");
		String senha = sc.nextLine();

		if (BancoBO.logar(login, senha) != null) {
			Usuario usuario = BancoBO.logar(login, senha);

			if (usuario.getCargo().equals(RoleEnum.ADMINISTRADOR)) {
				menuADM();
			} else {
				menuTitular();
			}
		}
	}

	private static void menuTitular() {
		System.out.println("Menu titular");

	}

	private static void menuADM() {
		// TODO Auto-generated method stub
		System.out.println("menu ADM");
	}

	private static void cadastrarUsuario(Scanner sc) {
		String nome, senha;

		System.out.println("Qual usuario você deseja possuir?");
		sc.nextLine();
		nome = sc.nextLine();

		System.out.println("Qual sua senha?");
		senha = sc.nextLine();
		// TODO Auto-generated method stub

		Usuario usuario = new Usuario(nome, senha, RoleEnum.TITULAR);
		BancoBO.salvarUsuario(usuario);

	}

}