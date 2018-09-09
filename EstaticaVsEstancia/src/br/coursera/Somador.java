package br.coursera;

public class Somador {
	
	String nome;
	int valorInstancia = 0;
	static int valorEstatica = 0;
	
	void somar(){
		valorInstancia ++;
		valorEstatica ++;
	}
	
	void imprimir(){
		System.out.println("O somador "+nome+ " : intancia = " + valorInstancia+ " e estatica = "+valorEstatica);
		
		
	}

}
