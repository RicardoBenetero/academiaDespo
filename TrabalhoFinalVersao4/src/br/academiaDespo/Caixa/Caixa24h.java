package br.academiaDespo.Caixa;

import java.math.BigDecimal;
import java.util.List;

import br.academiaDespo.Banco.Banco;
import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.SaldoInsuficienteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;



public class Caixa24h {
	
	Banco banco;

	public Caixa24h(Banco banco) {

		this.banco = banco;

	}

	
	public String getNome() {

		return banco.getNome();
	}


	public List<String> consultarExtrato(String numero) {
		return banco.consultarExtrato( numero);
	}

	
	public BigDecimal consultarSaldo(String numeroConta) throws ContaInexistenteException{
		
		return banco.consultarSaldo(numeroConta);
	}

	
	public void realizarTransferencia(String numeroContaDeposita,Double valor, String numeroContaRecebeDeposito)throws ContaInexistenteException,ValorInvalidoException {
		banco.realizarTransferencia(numeroContaDeposita,valor, numeroContaRecebeDeposito);

	}


	public void realizarDeposito(String numeroConta,Double valor) throws ContaInexistenteException,ValorInvalidoException{
		banco.realizarDeposito(numeroConta,valor);

	}

	
	public void sacar(String numeroConta,Double valor)throws ContaInexistenteException,SaldoInsuficienteException {
		banco.sacar(numeroConta,valor);

	}

}



