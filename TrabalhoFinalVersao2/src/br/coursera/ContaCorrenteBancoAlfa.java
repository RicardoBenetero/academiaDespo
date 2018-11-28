package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteBancoAlfa implements Conta {

	private Double saldo = 0.00;
	private String numeroConta;
	private List<String> transacoesEfetuadas = new ArrayList<String>();
	private String insereTransacaoNoExtrato;

	public ContaCorrenteBancoAlfa(String numeroConta) {

		this.numeroConta = numeroConta;

	}
//com regras diferentes do banco beta
	public void consultarExtrato() {
		
		System.out.println(transacoesEfetuadas);
	}

	public double consultarSaldo() {
		
		return 10.00;
	}

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		
		insereTransacaoNoExtrato = "operação realizada = realizar tranferencia: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
			
			contaDeposita.sacar(10.00);
			
			contaRecebeDeposito.realizarDeposito(10.00);
			
		
		

	}

	public void realizarDeposito(Double valor) {
		
		insereTransacaoNoExtrato = "operação realizada = realizar deposito: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);

		this.saldo = saldo + 10.00;

	}

	public void sacar(Double valor) throws SaldoInsuficienteException {
		
		

		if (valor <= this.saldo) {

			this.saldo = this.saldo - 10.00;
			insereTransacaoNoExtrato = "operação realizada = realizar saque: " + 10.00;
			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

	}

	public String getNumeroConta() {
		return numeroConta;
	}

}

