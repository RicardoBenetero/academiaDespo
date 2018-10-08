package br.coursera;

public class Carro {
	
	private int potencia;
	private int velocidade;
	private String nome;
	private int velocidadeMaxima;
	
	
	
	public Carro(String nome, int potencia, int velocidadeMaxima) {
		super();
		this.nome = nome;
		this.potencia = potencia;
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public void acelerar() {
		
		velocidade = velocidade + potencia;
	}
	
	public void frear() {
		
		velocidade = velocidade /2;
	}
	
	public int getVelocidade() {
		
		return velocidade;
		
	}
	
	public void imprimir() {
		
		System.out.println ("O carro " + nome + " está a velocidade de "+getVelocidade()+" Km/h");
	}

}