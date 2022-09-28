package br.com.rodrigo.senai.dev.caixa.domain;

public class Usuario {

	private RoleEnum cargo;
	private String nome;
	private int senha;
	private double saldo=2000;
	
	public Usuario(String nome, int senha, RoleEnum cargo) {

		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
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
		return "Usuario [cargo=" + cargo + ", nome=" + nome + ", senha=" + senha + "]\n";
	}

}