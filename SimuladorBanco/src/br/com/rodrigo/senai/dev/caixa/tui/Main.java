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
		Usuario ADM = new Usuario("ADM", "12345", RoleEnum.ADMINISTRADOR);
		BancoBO.salvarUsuario(ADM);

		Scanner sc = new Scanner(System.in);
		System.out.println("Olá, bem vindo ao caixa tenditudo");
		System.out.println("Você já possui um login? Digite 1 para Sim ou digite qualquer numero para Não");
		int menu = sc.nextInt();

		if (menu == 1) {
			logar(sc);
		} else {
			cadastrarUsuario(sc);
		}

	}

	private static void logar (Scanner sc) {
		
		System.out.println("Insira seu login:");
		String login = sc.nextLine();
		sc.nextLine();
		System.out.println("Insira sua senha:");
		String senha = sc.nextLine();

		if (BancoBO.logar(login, senha) == true) {
			
			Usuario usuario = BancoBO.buscarUsuario(login);
			
			System.out.println(usuario);
			if (usuario.getCargo().equals(RoleEnum.ADMINISTRADOR)) {
				menuADM();
			} else {
				menuTitular();
			}

		} else {
			System.out.println("Usuario não encontrado ou senha incorreto");
		}
	}
	private static void menuTitular() {
		// TODO Auto-generated method stub

	}

	private static void menuADM() {
		// TODO Auto-generated method stub
		System.out.println("Sou puta e burra");
	}

	private static void cadastrarUsuario(Scanner sc) {
		String nome, senha;

		System.out.println("Qual usuario você deseja possuir?");
		nome = sc.nextLine();
		sc.nextLine();
		System.out.println("Qual sua senha?");
		senha = sc.nextLine();
		// TODO Auto-generated method stub

		Usuario usuario = new Usuario(nome, senha, RoleEnum.TITULAR);
		BancoBO.salvarUsuario(usuario);
		
	}

}
