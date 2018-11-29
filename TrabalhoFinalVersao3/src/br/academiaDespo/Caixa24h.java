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
	public double consultarSaldo() {
		
		return banco.consultarSaldo();
	}

	@Override
	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		banco.realizarTransferencia(contaDeposita,valor, contaRecebeDeposito);

	}

	@Override
	public void realizarDeposito(Double valor) throws ValorInvalidoException{
		banco.realizarDeposito(valor);

	}

	@Override
	public void sacar(Double valor)throws SaldoInsuficienteException {
		banco.sacar(valor);

	}

}
