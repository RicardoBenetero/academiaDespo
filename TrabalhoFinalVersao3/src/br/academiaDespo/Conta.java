package br.academiaDespo;

import java.util.List;

public interface Conta {
	
	public List<String> consultarExtrato();

	public double consultarSaldo(String numero);

	public void realizarTransferencia(String numeroContadeposita,Double valor, String numeroContaRecebeDeposito);

	public void realizarDeposito(String numero,Double valor);

	public void sacar(String numero,Double valor);
	
	public String getNumero();
}
