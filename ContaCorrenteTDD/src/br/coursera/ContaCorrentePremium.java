package br.coursera;

public class ContaCorrentePremium implements ContaCorrente {
	
	public static double TAXA_JUROS_FIXA = 1.0;
	private static double REMUNERACAO = 1.06;
	private double saldo;

	@Override
	public void depositar(Double valor) {
		this.saldo = saldo + REMUNERACAO * valor;
		
	}

	@Override
	public double obterSaldo() {
		return saldo;
	}

	@Override
	public double calcularTaxaJuros() {
		return TAXA_JUROS_FIXA ;
	}

	
}
