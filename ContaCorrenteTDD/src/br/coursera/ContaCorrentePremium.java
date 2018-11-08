package br.coursera;

public class ContaCorrentePremium implements ContaCorrente {
	
	private static double TAXA_JUROS_FIXA = 1.0;
	private static double REMUNERACAO = 1.06;
	private static double LIMITE_SALDO_PREMIUM = 50.00;
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

	@Override
public void efetuarRetirada(Double valor) {
		
		if (valor <= this.saldo + LIMITE_SALDO_PREMIUM) {
		
		this.saldo = this.saldo - valor;
		}else {
		throw new SaldoInsuficienteException("Saldo insuficiente");
		
	}
	}

	
}
