package br.academiaDespo;

import java.util.List;

public interface Banco {
	
	public String getNome();
	
	public List<String> consultarExtrato();

	public double consultarSaldo();

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito);

	public void realizarDeposito(Double valor);

	public void sacar(Double valor);


}
