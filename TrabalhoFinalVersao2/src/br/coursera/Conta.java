package br.coursera;

import java.util.ArrayList;
import java.util.List;

public interface Conta {
	
	

	public void consultarExtrato();

	public double consultarSaldo();

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito);

	public void realizarDeposito(Double valor);

	public void sacar(Double valor);
	
	public String getNumeroConta();

}
