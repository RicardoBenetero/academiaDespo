package br.coursera;

public class ContaCorrenteRegular implements ContaCorrente {

	private static double TAXA_JUROS_FIXA = 5.0;
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

	@Override
	public void efetuarRetirada(Double valor) {
		
		if (valor <= this.saldo) {
		
		this.saldo = this.saldo - valor;
		}else {
		throw new SaldoInsuficienteException("Saldo insuficiente");
		
	}

}
}
