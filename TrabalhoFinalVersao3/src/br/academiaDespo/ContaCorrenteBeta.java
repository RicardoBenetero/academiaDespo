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
	public double consultarSaldo() {
		insereTransacaoNoExtrato = "operação realizada = consulta saldo: " + saldo;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
		return saldo;
	}
	@Override
	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		insereTransacaoNoExtrato = "operação realizada = realizar tranferencia: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
			
			contaDeposita.sacar(valor);
			
			contaRecebeDeposito.realizarDeposito(valor);
		
	}
	@Override
	public void realizarDeposito(Double valor)throws ValorInvalidoException {
		insereTransacaoNoExtrato = "operação realizada = realizar deposito: " + valor;
		transacoesEfetuadas.add(insereTransacaoNoExtrato);
        if(valor > 0) {
		this.saldo = saldo + valor;
        } else {
			throw new ValorInvalidoException("Valor invalido");
        }
	}

	
	@Override
	public void sacar(Double valor) throws SaldoInsuficienteException{
		if (valor <= this.saldo) {

			this.saldo = this.saldo - valor;
			insereTransacaoNoExtrato = "operação realizada = realizar saque: " + valor;
			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}
		
	}
	
	

}
