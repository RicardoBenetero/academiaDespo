package br.academiaDespo;

import java.util.ArrayList;
import java.util.List;

import br.academiaDespo.SaldoInsuficienteException;


public class ContaCorrenteBeta implements Conta {
	
	private String numero;
	private Double saldo = 0.0;
	private List<String> transacoesEfetuadas = new ArrayList<String>();
	private String insereTransacaoNoExtrato;
	
	public ContaCorrenteBeta(String numero) {
		
		
		this.numero = numero;
	}
	
	@Override
	public List<String> consultarExtrato() {
		return transacoesEfetuadas;		
	}
	@Override
	public double consultarSaldo(String numero) {
		insereTransacaoNoExtrato = "opera��o realizada = consulta saldo: " + saldo;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
		return saldo;
	}
	@Override
	public void realizarTransferencia(String numeroContadeposita,Double valor, String numeroContaRecebeDeposito) {
		insereTransacaoNoExtrato = "opera��o realizada = realizar tranferencia: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
			System.out.println("classe contacorrente metodo transferir numeroContaRecebeDeposito" +numeroContadeposita +" "+ valor);
			sacar(numeroContadeposita,valor);
			System.out.println("classe contacorrente metodo transferir saldo " +consultarSaldo(numeroContadeposita));
			System.out.println("classe contacorrente metodo transferir saldo numeroContaRecebeDeposito " +consultarSaldo(numeroContaRecebeDeposito));

			realizarDeposito(numeroContaRecebeDeposito,valor);
			System.out.println("classe contacorrente metodo transferir saldo 2 " +numeroContaRecebeDeposito+ " "+consultarSaldo(numeroContaRecebeDeposito) + "valor " + valor);
	}
	@Override
	public void realizarDeposito(Conta conta,String numero,Double valor)throws ValorInvalidoException {
		insereTransacaoNoExtrato = "opera��o realizada = realizar deposito: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
        if(valor > 0) {
		this.saldo = saldo + valor;
        } else {
			throw new ValorInvalidoException("Valor invalido");
        }
	}

	
	@Override
	public void sacar(String numero,Double valor) throws SaldoInsuficienteException{
		if (valor <= this.saldo) {

			this.saldo = this.saldo - valor;
			insereTransacaoNoExtrato = "opera��o realizada = realizar saque: " + valor;
			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}
		
	}

	public String getNumero() {
		return numero;
	}
	
	

}
