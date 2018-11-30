package br.academiaDespo;

import java.util.List;

public class Caixa24h implements Banco {

	Banco banco;

	public Caixa24h(Banco banco) {

		this.banco = banco;

	}

	@Override
	public String getNome() {

		return banco.getNome();
	}

	@Override
	public List<String> consultarExtrato() {
		return banco.consultarExtrato();
	}

	@Override
	public double consultarSaldo(String numeroConta) throws ContaInexistenteException{
		
		return banco.consultarSaldo(numeroConta);
	}

	@Override
	public void realizarTransferencia(String numeroContaDeposita,Double valor, String numeroContaRecebeDeposito)throws ContaInexistenteException,ValorInvalidoException {
		banco.realizarTransferencia(numeroContaDeposita,valor, numeroContaRecebeDeposito);

	}

	@Override
	public void realizarDeposito(String numeroConta,Double valor) throws ContaInexistenteException,ValorInvalidoException{
		banco.realizarDeposito(numeroConta,valor);

	}

	@Override
	public void sacar(String numeroConta,Double valor)throws ContaInexistenteException,SaldoInsuficienteException {
		banco.sacar(numeroConta,valor);

	}

}
