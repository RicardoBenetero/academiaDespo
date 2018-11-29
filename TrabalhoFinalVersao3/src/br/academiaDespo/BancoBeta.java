package br.academiaDespo;

import java.util.List;

public class BancoBeta implements Banco {

	private final static String NOME = "BANCO BETA";
	Conta conta;

	public BancoBeta(Conta conta) {

		this.conta= conta;
	}

	@Override
	public String getNome() {

		return NOME;
	}

	@Override
	public List<String> consultarExtrato() {
		return conta.consultarExtrato();
		
		 
	}

	@Override
	public double consultarSaldo() {
		return conta.consultarSaldo();
    
	}

	@Override
	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito) {
		conta.realizarTransferencia(contaDeposita, valor, contaRecebeDeposito);
	}

	@Override
	public void realizarDeposito(Double valor) {
		conta.realizarDeposito(valor);
	}

	@Override
	public void sacar(Double valor) {
		conta.sacar(valor);

	}

}
