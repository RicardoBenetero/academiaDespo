package br.coursera;

public class Principal {

	public static void main(String[] args) {

		Moeda moedaUmReal = new Moeda();
		moedaUmReal.valorMoeda = "moedaUmReal";

		Moeda moedaCinquentaCentavos = new Moeda();
		moedaCinquentaCentavos.valorMoeda = "moedaCinquentaCentavos";

		Moeda moedaVinteECincoCentavos = new Moeda();
		moedaVinteECincoCentavos.valorMoeda = "moedaVinteECincoCentavos";

		Moeda moedaDezCentavos = new Moeda();
		moedaDezCentavos.valorMoeda = "moedaDezCentavos";

		Moeda moedaCincoCentavos = new Moeda();
		moedaCincoCentavos.valorMoeda = "moedaCincoCentavos";

		Moeda moedaUmCentavo = new Moeda();
		moedaUmCentavo.valorMoeda = "moedaUmCentavo";

		Moeda moedaTrintaCentavos = new Moeda();
		moedaTrintaCentavos.valorMoeda = "moedaTrintaCentavos";

		Cofrinho cofrinho = new Cofrinho();

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmCentavo);

		cofrinho.contaNumeroMoedasArmazenadas(moedaVinteECincoCentavos);

		cofrinho.contaNumeroMoedasArmazenadas(moedaTrintaCentavos);

		System.out.println("Quantidade de moedas adicionadas no cofrinho: " + cofrinho.getQuantidadeMoedas() + "\n");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Quantidade de moedas de Um Real: " + cofrinho.getMoedaUmReal() + "\n");
		System.out.println("Quantidade de moedas de Um Centavo: " + cofrinho.moedaUmCentavo + "\n");
		System.out.println("Quantidade de moedas de Cinco Centavos: " + cofrinho.moedaCincoCentavos + "\n");
		System.out.println("Quantidade de moedas de Dez Centavos: " + cofrinho.moedaDezCentavos + "\n");
		System.out
				.println("Quantidade de moedas de Vinte E Cinco Centavos: " + cofrinho.moedaVinteECincoCentavos + "\n");
		System.out.println("Quantidade de moedas de Cinquenta Centavos: " + cofrinho.moedaCinquentaCentavos + "\n");
		System.out.println("-------------------------------------------------------------------------------------");

		cofrinho.informaMoedaMaiorValor();

	}

}
