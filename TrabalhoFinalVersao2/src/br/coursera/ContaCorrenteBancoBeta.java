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
        if (valor > 0){
		this.saldo = saldo + valor;
        }else{
        	throw new ValorInvalidoException("Valor Deposito invalido");
        	
        }
	}

	public void sacar(Double valor) throws SaldoInsuficienteException {
		
		

		if (valor <= this.saldo) {

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
