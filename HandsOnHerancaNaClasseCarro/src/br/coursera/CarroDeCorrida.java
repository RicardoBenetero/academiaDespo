package br.coursera;

public abstract class CarroDeCorrida {

	public abstract void acelerar();

	protected int velocidade;
	protected String nome;
	protected int velocidadeMaxima;
	
	public CarroDeCorrida(String nome,  int velocidadeMaxima) {
		super();
		this.nome = nome;
		this.velocidadeMaxima = velocidadeMaxima;
		this.velocidade =0;
	}

	public void frear() {
		
		velocidade = velocidade /2;
	}

	public int getVelocidade() {
		
		return velocidade;
		
	}

	public String getNome() {
		return nome;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

}
