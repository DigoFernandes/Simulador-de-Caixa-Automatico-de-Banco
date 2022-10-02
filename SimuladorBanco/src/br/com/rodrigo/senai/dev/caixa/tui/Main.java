package br.com.rodrigo.senai.dev.caixa.tui;

import java.util.Scanner;

import br.com.rodrigo.senai.dev.caixa.business.BancoBO;
import br.com.rodrigo.senai.dev.caixa.dao.BancoDAO;
import br.com.rodrigo.senai.dev.caixa.domain.Nota;
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
		Integer saida;
		
		Scanner sc = new Scanner(System.in);
			System.out.println("Olá, bem vindo ao caixa tenditudo");
			System.out.println("Você já possui um login?Digite 1 para Sim e 2 para nao");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("Insira seu login:");
				String login = sc.nextLine();
				sc.nextLine();
				System.out.println("Insira sua senha:");
				String senha = sc.nextLine();
				
				if (BancoBO.logar(login, senha) == true) {
					Usuario usuario = BancoBO.buscarUsuario(login);
					
					if (usuario.getCargo() == RoleEnum.ADMINISTRADOR) {
						menuADM();
					} else {
						menuPLEBEU();
					}

				} else {
					System.out.println("Usuario não encontrado ou senha incorreto");
				}

			}else {
				System.out.println("Socorro");
			}
	
		}

	private static void menuPLEBEU() {
		// TODO Auto-generated method stub

	}

	private static void menuADM() {
		// TODO Auto-generated method stub

	}

}
