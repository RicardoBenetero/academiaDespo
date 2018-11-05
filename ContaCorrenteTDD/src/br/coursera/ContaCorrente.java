package br.coursera;

public interface ContaCorrente {
	
	public void depositar(Double valor);
	public double obterSaldo();
	public double calcularTaxaJuros();

}
