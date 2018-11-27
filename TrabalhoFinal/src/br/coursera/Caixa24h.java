package br.coursera;

public class Caixa24h {

	Banco banco;

	public Caixa24h(Banco banco) {

		this.banco = banco;

	}

	public void consultarExtrato(Cliente cliente) {
		
		cliente.conta.consultarExtrato();

	}

	public double consultarSaldo(Cliente cliente) {

		return cliente.conta.consultarSaldo();

	}

	public void realizarTransferencia(Cliente cliente,Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		
		cliente.conta.realizarTransferencia(contaDeposita, valor, contaRecebeDeposito);
		

	}

	public void realizarDeposito(Cliente cliente, Double valor) {
		cliente.conta.realizarDeposito(valor);

	}

	public void Sacar(Cliente cliente, Double valor) {

		cliente.conta.sacar(valor);

	}

}
