package br.coursera;

import java.util.Date;

public class CartaoCredito extends Pagamento {

	
	private int numero;
	private String tipo;
	private Date dataExp;
	private int limite;
	
	public boolean isAutorizado(int limite) {
		
		this.limite = limite;
		if (this.limite >= 3000 ) {
			
			return true;

		}
		return false;
		
		
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Date getDataExp() {
		return dataExp;
	}


	public void setDataExp(Date dataExp) {
		this.dataExp = dataExp;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	
}
