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
	public double consultarSaldo(String numero) throws ContaInexistenteException{
		
		return banco.consultarSaldo(numero);
	}

	@Override
	public void realizarTransferencia(String numeroContaDeposita,Double valor, String numeroContaRecebeDeposito)throws ContaInexistenteException {
		banco.realizarTransferencia(numeroContaDeposita,valor, numeroContaRecebeDeposito);

	}

	@Override
	public void realizarDeposito(String numero,Double valor) throws ValorInvalidoException{
		banco.realizarDeposito(numero,valor);

	}

	@Override
	public void sacar(String numero,Double valor)throws SaldoInsuficienteException {
		banco.sacar(numero,valor);

	}

}
