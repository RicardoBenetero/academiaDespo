package br.gov.serpro.banco;

public class Extrato {

	private String data;
	private int credito;
	private int debito;

	public Extrato(String data, int credito, int debito) {
		this.data = data;
		this.credito = credito;
		this.debito = debito;
	}

	public String getData() {
		return data;
	}

	public int getCredito() {
		return credito;
	}

	public int getDebito() {
		return debito;
	}
	
	
	

}
