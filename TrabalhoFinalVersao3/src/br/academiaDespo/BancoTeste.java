package br.academiaDespo;

import java.util.ArrayList;
import java.util.List;

public class BancoTeste implements Banco {

	private final static String NOME = "BANCO TESTE";
	List<Conta> contas = new ArrayList<Conta>();

	public BancoTeste(List<Conta> contas) {

		this.contas = contas;
	}

	@Override
	public String getNome() {

		return NOME;
	}

	@Override
	public List<String> consultarExtrato() {
		return contas.iterator().next().consultarExtrato();

	}

	@Override
	public double consultarSaldo(String numeroConta) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroConta)) {
				return conta.consultarSaldo(null);
			}
		}

		throw new ContaInexistenteException("Conta Inexistente");
	}

	@Override
	public void realizarTransferencia(String numeroContadeposita, Double valor,
			String numeroContaRecebeDeposito) throws ContaInexistenteException {

		if (contas.iterator().next().getNumero().equals(numeroContadeposita)) {

			contas.iterator()
					.next()
					.realizarTransferencia(numeroContadeposita, valor,
							numeroContaRecebeDeposito);

		} else {

			throw new ContaInexistenteException("Conta Inexistente");
		}

	}

	@Override
	public void realizarDeposito(String numeroConta, Double valor)
			throws ContaInexistenteException {

		if (contas.iterator().next().getNumero().equals(numeroConta)) {

			contas.iterator().next().realizarDeposito(numeroConta, valor);
		} else
			throw new ContaInexistenteException("Conta Inexistente");

	}

	@Override
	public void sacar(String numeroConta, Double valor)
			throws ContaInexistenteException {
		if (contas.iterator().next().getNumero().equals(numeroConta)) {
			contas.iterator().next().sacar(numeroConta, valor);
		} else
			throw new ContaInexistenteException("Conta Inexistente");

	}

}
