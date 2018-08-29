package br.coursera.carros;

public class Carro {
	
	int potencia;
	int velocidade;
	String nome;
	
	void acelerar() {
		
		velocidade = velocidade + potencia;
	}
	
	void frear() {
		
		velocidade = velocidade /2;
	}
	
	int getVelocidade() {
		
		return velocidade;
		
	}
	
	void imprimir() {
		
		System.out
	}

}
