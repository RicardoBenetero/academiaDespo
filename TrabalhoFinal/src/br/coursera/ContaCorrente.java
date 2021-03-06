package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente implements Conta {

	private Double saldo = 0.00;
	private String numeroConta;
	private List<String> transacoesEfetuadas = new ArrayList<String>();
	private String insereTransacaoNoExtrato;

	public ContaCorrente(String numeroConta) {

		this.numeroConta = numeroConta;

	}

	public List<String> consultarExtrato() {
		
		return transacoesEfetuadas;
	}

	public double consultarSaldo() {
		insereTransacaoNoExtrato = "opera��o realizada = consulta saldo: " + saldo;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
		return saldo;
	}

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		
		insereTransacaoNoExtrato = "opera��o realizada = realizar tranferencia: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
			
			contaDeposita.sacar(valor);
			
			contaRecebeDeposito.realizarDeposito(valor);
			
		
		

	}

	public void realizarDeposito(Double valor) {
		
		insereTransacaoNoExtrato = "opera��o realizada = realizar deposito: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);

		this.saldo = saldo + valor;

	}

	public void sacar(Double valor) throws SaldoInsuficienteException {
		
		

		if (valor <= this.saldo && valor < 0) {

			this.saldo = this.saldo - valor;
			insereTransacaoNoExtrato = "opera��o realizada = realizar saque: " + valor;
			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

	}

	public String getNumeroConta() {
		return numeroConta;
	}

}
