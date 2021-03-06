package br.coursera;

public class Caixa24h {

	private Banco banco;

	public Caixa24h(Banco banco) {

		this.banco = banco;

	}

	public void consultarExtrato(Banco banco) {

		banco.consultarExtrato();

	}

	public double consultarSaldo() {

		return banco.consultarSaldo("1234");

	}

	public void realizarTransferencia(Cliente cliente, Conta contaDeposita,
			Double valor, Conta contaRecebeDeposito) {

		banco.realizarTransferencia(contaDeposita, valor, contaRecebeDeposito);

	}

	public void realizarDeposito(Cliente cliente, Double valor)
			throws ValorInvalidoException {
		banco.realizarDeposito(valor);

	}

	public void sacar(Cliente cliente, Double valor)
			throws SaldoInsuficienteException {

		banco.sacar();

	}

}
