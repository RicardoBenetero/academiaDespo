package br.coursera;

public class Principal {

	public static void main(String[] args) {

		Corrida corridaDaAmizade = new Corrida(2000);
			
		corridaDaAmizade.adiciona(new CarroSoma("CarroA", 10, 110));	
		corridaDaAmizade.adiciona(new CarroSoma("CarroB", 8, 140));	
		corridaDaAmizade.adiciona(new CarroMult("CarroC", 1.7, 100));	
		corridaDaAmizade.adiciona(new CarroMult("CarroD", 1.4, 150));
		
		corridaDaAmizade.umDoisTresEJa();



			
			
			
			
		
	}

}
