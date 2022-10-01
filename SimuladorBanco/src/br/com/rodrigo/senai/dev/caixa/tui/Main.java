package br.com.rodrigo.senai.dev.caixa.tui;

import br.com.rodrigo.senai.dev.caixa.business.BancoBO;
import br.com.rodrigo.senai.dev.caixa.dao.BancoDAO;
import br.com.rodrigo.senai.dev.caixa.domain.RoleEnum;
import br.com.rodrigo.senai.dev.caixa.domain.Usuario;
import br.com.rodrigo.senai.dev.caixa.exception.SaldoInsuficienteException;
import br.com.rodrigo.senai.dev.caixa.exception.ValorInvalidoException;

public class Main {

	public static void main(String[] args){
		
		Usuario usuario = new Usuario("Rodrigo", 123, RoleEnum.ADMINISTRADOR);
		Usuario usuario2 = new Usuario("RLun", 1223, RoleEnum.ADMINISTRADOR);

		BancoBO.salvarUsuario(usuario);
		BancoBO.salvarUsuario(usuario2);
		
		try {
			BancoBO.depositar(usuario, 100);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		
		try {
			BancoBO.sacar(usuario2, 1100);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(BancoDAO.Listar());
		
	}
	
}
