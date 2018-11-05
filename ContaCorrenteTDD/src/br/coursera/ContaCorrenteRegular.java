package br.coursera;

public class ContaCorrenteRegular implements ContaCorrente {

	public static double TAXA_JUROS_FIXA = 5.0;
	private double saldo;


	@Override
	public void depositar(Double valor) {
		this.saldo = saldo + valor;

	}

	@Override
	public double obterSaldo() {
		return saldo;
	}

	@Override
	public double calcularTaxaJuros() {

		return TAXA_JUROS_FIXA;
	}

}
