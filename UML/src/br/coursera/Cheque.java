package br.coursera;

public class Cheque extends Pagamento{
	
	private String nomeBanco;
	private int IdBanco;
	private int limite;
	
	public boolean isAutorizado(int limite) {
		this.limite = limite;
		if (this.limite >= 3000) {
			
			return true;

		}
		return false;
		
		
	}


	public String getNomeBanco() {
		return nomeBanco;
	}


	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}


	public int getIdBanco() {
		return IdBanco;
	}


	public void setIdBanco(int idBanco) {
		IdBanco = idBanco;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	
	

}
