package br.coursera;

public class Principal {

	public static void main(String[] args) {
		
		Conta contaCorrenteBeta = new ContaCorrenteBancoBeta("1234");
		Banco bancoBetA = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBetA);
		
		contaCorrenteBeta.realizarDeposito(200.00);
		atm.consultarSaldo();

	}

}
