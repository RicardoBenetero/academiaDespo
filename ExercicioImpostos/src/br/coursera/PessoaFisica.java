package br.coursera;

public class PessoaFisica implements Contribuinte{
	
	private String nome;
	private double renda;
	private String cpf;
	
	
	public PessoaFisica(String nome, Double renda,String cpf) {
		
		this.nome = nome;
		this.renda = renda;
		this.cpf = cpf;
		
	}
	
	public double calcularImposto() {
		return renda;
		
		
		
	}

}
