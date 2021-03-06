package br.coursera;

import java.util.ArrayList;
import java.util.List;

public interface Banco {
	
	List<String> contas = new ArrayList<String>();
	public String getNome();
	public void consultarExtrato();

	public double consultarSaldo(String numeroConta);

	public void realizarTransferencia(Conta contaDeposita,Double valor, Conta contaRecebeDeposito);

	public void realizarDeposito(Double valor);

	public void sacar(Double valor);

 

}
