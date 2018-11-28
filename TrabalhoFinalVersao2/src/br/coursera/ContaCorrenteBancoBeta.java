package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteBancoBeta implements Conta {

	private Double saldo = 0.00;
	private String numeroConta;
	private List<String> transacoesEfetuadas = new ArrayList<String>();
	private String insereTransacaoNoExtrato;

	public ContaCorrenteBancoBeta(String numeroConta) {

		this.numeroConta = numeroConta;

	}

	public void consultarExtrato() {
		
		System.out.println(transacoesEfetuadas);
	}

	public double consultarSaldo() {
		insereTransacaoNoExtrato = "operação realizada = consulta saldo: " + saldo;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
		return saldo;
	}

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		
		insereTransacaoNoExtrato = "operação realizada = realizar tranferencia: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
			
			contaDeposita.sacar(valor);
			
			contaRecebeDeposito.realizarDeposito(valor);
			
		
		

	}

	public void realizarDeposito(Double valor) {
		
		insereTransacaoNoExtrato = "operação realizada = realizar deposito: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);

		this.saldo = saldo + valor;

	}

	public void sacar(Double valor) throws SaldoInsuficienteException {
		
		

		if (valor <= this.saldo) {

			this.saldo = this.saldo - valor;
			insereTransacaoNoExtrato = "operação realizada = realizar saque: " + valor;
			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

	}

	public String getNumeroConta() {
		return numeroConta;
	}

}
