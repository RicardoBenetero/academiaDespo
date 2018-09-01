package br.coursera.carros;

public class Principal {

	public static void main(String[] args) {

		Carro ferrari = new Carro();
		ferrari.potencia = 10;
		ferrari.nome = "Ferrari";
		ferrari.velocidade = 0;
		
		Carro fusca = new Carro();
		fusca.potencia = 10;
		fusca.nome = "Fusca";
		fusca.velocidade = 0;
		
		Carro ferrariVermelha = new Carro();
		ferrariVermelha.potencia = 10;
		ferrariVermelha.nome = "Ferrari";
		ferrariVermelha.velocidade = 0;
		
		fusca.acelerar();
		fusca.acelerar();

		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();

		ferrari.frear();
		
		ferrari.imprimir();
		fusca.imprimir();
		System.out.println("imprimindo ferrariVermelha");
		ferrariVermelha.imprimir();
	}

}
