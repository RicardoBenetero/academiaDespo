package br.coursera.carros;

public class Carro {
	
	public int potencia;
	public int velocidade;
	public String nome;
	
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
