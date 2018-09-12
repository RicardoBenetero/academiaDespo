package br.coursera;

public class Principal {

	public static void main(String[] args) {

		
		Cofrinho cofrinho = new Cofrinho();
		
		
		cofrinho.contaNumeroMoedasArmazenadas("moedaUmReal");
		cofrinho.contaNumeroMoedasArmazenadas("moedaCincoCentavos");
		cofrinho.contaNumeroMoedasArmazenadas("moedaCincoCentavos");

		cofrinho.contaNumeroMoedasArmazenadas("notaCinco");


		System.out.println("Quantidade de moedas adicionadas no cofrinho: " + cofrinho.getQuantidadeMoedas());
		System.out.println("Quantidade de moedas de Um Real: " + cofrinho.getMoedaUmReal());
		System.out.println("Quantidade de moedas de Um Centavo: " + cofrinho.moedaUmCentavo);
		System.out.println("Quantidade de moedas de Cinco Centavos: " + cofrinho.moedaCincoCentavos);
		System.out.println("Quantidade de moedas de Dez Centavos: " + cofrinho.moedaDezCentavos);
		System.out.println("Quantidade de moedas de Vinte E Cinco Centavos: " + cofrinho.moedaVinteECincoCentavos);
		System.out.println("Quantidade de moedas de Cinquenta Centavos: " + cofrinho.moedaCinquentaCentavos);


		
	
		

	}

}
