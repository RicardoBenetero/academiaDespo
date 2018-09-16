package br.coursera;

public class Cofrinho {
	private int moedaUmCentavo;
	private int moedaCincoCentavos;
	private int moedaDezCentavos;
	private int moedaVinteECincoCentavos;
	private int moedaCinquentaCentavos;
	private int moedaUmReal;

	private int quantidadeMoedas;

	public void contaNumeroMoedasArmazenadas(Moeda moeda) {

		if (moeda.valorMoeda.equals("moedaUmCentavo") || moeda.valorMoeda.equals("moedaCincoCentavos")
				|| moeda.valorMoeda.equals("moedaDezCentavos") || moeda.valorMoeda.equals("moedaVinteECincoCentavos")
				|| moeda.valorMoeda.equals("moedaCinquentaCentavos") || moeda.valorMoeda.equals("moedaUmReal")) {
			quantidadeMoedas++;
			contaNumeroMoedasDeterminadoValor(moeda);
		} else {

			System.out.println(moeda.valorMoeda + " - invalida nao foi adicionada ao cofrinho! ");
		}

	}

	public void contaNumeroMoedasDeterminadoValor(Moeda moeda) {

		if (moeda.valorMoeda.equals("moedaUmCentavo")) {

			moedaUmCentavo++;

		} else if (moeda.valorMoeda.equals("moedaCincoCentavos")) {

			moedaCincoCentavos++;
		} else if (moeda.valorMoeda.equals("moedaDezCentavos")) {

			moedaDezCentavos++;
		}

		else if (moeda.valorMoeda.equals("moedaVinteECincoCentavos")) {

			moedaVinteECincoCentavos++;
		}

		else if (moeda.valorMoeda.equals("moedaCinquentaCentavos")) {

			moedaCinquentaCentavos++;
		}

		else if (moeda.valorMoeda.equals("moedaUmReal")) {

			moedaUmReal++;
		}

	}

	public String informaMoedaMaiorValor() {

		if (this.moedaUmReal != 0) {
		return "Moeda de maior valor no cofrinho - moeda De Um Real";

		} else if (this.moedaCinquentaCentavos != 0) {
			return "Moeda de maior valor no cofrinho - moeda Cinquenta Centavos";

		} else if (this.moedaVinteECincoCentavos != 0) {
			return "Moeda de maior valor no cofrinho - moeda Vinte E Cinco Centavos";

		} else if (this.moedaDezCentavos != 0) {
			return "Moeda de maior valor no cofrinho - moeda Dez Centavos";

		} else if (this.moedaCincoCentavos != 0) {
			return "Moeda de maior valor no cofrinho - moeda Cinco Centavos";

		} else 
			return "Moeda de maior valor no cofrinho - moeda Um Centavo";
		
	}

	public int getQuantidadeMoedas() {
		return quantidadeMoedas;
	}

	public int getMoedaUmCentavo() {
		return moedaUmCentavo;
	}

	public int getMoedaCincoCentavos() {
		return moedaCincoCentavos;
	}

	public int getMoedaDezCentavos() {
		return moedaDezCentavos;
	}

	public int getMoedaVinteECincoCentavos() {
		return moedaVinteECincoCentavos;
	}

	public int getMoedaCinquenta() {
		return moedaCinquentaCentavos;
	}

	public int getMoedaUmReal() {
		return moedaUmReal;
	}

}
