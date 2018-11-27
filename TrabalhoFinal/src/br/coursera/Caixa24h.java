package br.coursera;

public class Caixa24h {

	Banco banco;

	public Caixa24h(Banco banco) {

		this.banco = banco;

	}

	public void consultarExtrato() {

	}

	public double consultarSaldo(Cliente cliente) {

		return cliente.conta.consultarSaldo();

	}

	public void realizarTransferencia() {

	}

	public void realizarDeposito(Cliente cliente, Double valor) {
		cliente.conta.realizarDeposito(valor);

	}

	public void Sacar(Cliente cliente, Double valor) {

		cliente.conta.sacar(valor);

	}

}
