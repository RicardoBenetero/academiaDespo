package br.coursera;

public class ContaCorrentePremium implements ContaCorrente {
	
	public static double TAXA_JUROS_FIXA = 1.0;
	private double saldo;

	@Override
	public void depositar(Double valor) {
		this.saldo = saldo + 1.06 * valor;
		
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
