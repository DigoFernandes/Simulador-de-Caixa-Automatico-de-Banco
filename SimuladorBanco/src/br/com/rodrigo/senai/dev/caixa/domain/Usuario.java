package br.com.rodrigo.senai.dev.caixa.domain;

public class Usuario {

	private RoleEnum cargo;
	private String nome;
	private int senha;
	private int saldo;
	
	public Usuario(String nome, int senha, RoleEnum cargo) {

		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public RoleEnum getCargo() {
		return cargo;
	}

	public void setCargo(RoleEnum cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [cargo=" + cargo + ", nome=" + nome + ", senha=" + senha + ", saldo=" + saldo + "]";
	}

	

}