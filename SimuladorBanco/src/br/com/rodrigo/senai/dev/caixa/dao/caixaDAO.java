package br.com.rodrigo.senai.dev.caixa.dao;

public class caixaDAO {

public int saque(int saldo, int valor) {
	
		saldo = saldo - valor;
		return saldo;
}

public int deposito(int saldo, int valor) {
	
	saldo = saldo + valor;
	return saldo;
}
	
}

//Saldo|saque|Deposito