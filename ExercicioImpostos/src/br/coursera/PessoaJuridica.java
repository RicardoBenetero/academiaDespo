package br.coursera;

public class PessoaJuridica implements Contribuinte {
	
	private String nome;
	private double renda;
	private String cnpj;
	
	
public PessoaJuridica(String nome, Double renda,String cnpj) {
		
		this.nome = nome;
		this.renda = renda;
		this.cnpj = cnpj;
		
	}
	
	
	public double calcularImposto() {
		
	Double	resultado = (renda*10)/100;
		return resultado;
		
		
		
	}

}
