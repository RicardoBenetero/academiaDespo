package br.coursera;

public class ContaCorrente implements Conta {

	private Double saldo = 0.00;
	private String numeroConta;

	public ContaCorrente(String numeroConta) {

		this.numeroConta = numeroConta;

	}

	public void consultarExtrato() {

	}

	public double consultarSaldo() {

		return saldo;
	}

	public void realizarTransferencia() {

	}

	public void realizarDeposito(Double valor) {

		this.saldo = saldo + valor;

	}

	public void sacar(Double valor) throws SaldoInsuficienteException {

		if (valor <= this.saldo) {

			this.saldo = this.saldo - valor;
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

	}

	public String getNumeroConta() {
		return numeroConta;
	}

}
