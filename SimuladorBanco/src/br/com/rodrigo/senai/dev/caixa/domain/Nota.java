package br.com.rodrigo.senai.dev.caixa.domain;

public class Nota {
	
	private int cinquenta=1000,vinte=400,
			dez=200,dois=40, cont50,cont20,
			cont10,cont2;



	public Nota(int cinquenta, int vinte, int dez, int dois, int cont50, int cont20, int cont10, int cont2) {
		super();
		this.cinquenta = cinquenta;
		this.vinte = vinte;
		this.dez = dez;
		this.dois = dois;
		this.cont50 = cont50;
		this.cont20 = cont20;
		this.cont10 = cont10;
		this.cont2 = cont2;
	}
	

	public Nota() {
		
	}


	public int getCont50() {
		return cont50;
	}

	public void setCont50(int cont50) {
		this.cont50 = cont50;
	}

	public int getCont20() {
		return cont20;
	}

	public void setCont20(int cont20) {
		this.cont20 = cont20;
	}

	public int getCont10() {
		return cont10;
	}

	public void setCont10(int cont10) {
		this.cont10 = cont10;
	}

	public int getCont2() {
		return cont2;
	}

	public void setCont2(int cont2) {
		this.cont2 = cont2;
	}

	public int getCinquenta() {
		return cinquenta;
	}

	public void setCinquenta(int cinquenta) {
		this.cinquenta = cinquenta;
	}

	public int getVinte() {
		return vinte;
	}

	public void setVinte(int vinte) {
		this.vinte = vinte;
	}

	public int getDez() {
		return dez;
	}

	public void setDez(int dez) {
		this.dez = dez;
	}

	public int getDois() {
		return dois;
	}

	public void setDois(int dois) {
		this.dois = dois;
	}


	@Override
	public String toString() {
		return "Nota [cinquenta=" + cinquenta + ", vinte=" + vinte + ", dez=" + dez + ", dois=" + dois + ", cont50="
				+ cont50 + ", cont20=" + cont20 + ", cont10=" + cont10 + ", cont2=" + cont2 + "]";
	}
	
	
	
}
