package br.academiaDespo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.academiaDespo.Banco.Banco;
import br.academiaDespo.Banco.Conta;
import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;

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
	public List<String> consultarExtrato(String numero) {
		return consultarExtrato(numero);

	}

	@Override
	public BigDecimal consultarSaldo(String numeroConta) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroConta)) {
				return conta.consultarSaldo();
			}
		}

		throw new ContaInexistenteException("Conta Inexistente");
	}

	@Override
	public void realizarTransferencia(String numeroContadeposita, BigDecimal valor, String numeroContaRecebeDeposito)
			throws ContaInexistenteException, ValorInvalidoException {

		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroContadeposita)) {
				conta.sacar(valor);
				
			}
			if (conta.getNumero().equals(numeroContaRecebeDeposito)) {
				conta.realizarDeposito(valor);
				
			}
		}


	}

	@Override
	public void realizarDeposito(String numeroConta, BigDecimal valor)
			throws ContaInexistenteException, ValorInvalidoException {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroConta)) {

				conta.realizarDeposito( valor);

			}

		}
	}

	@Override
	public void sacar(String numeroConta, BigDecimal valor) throws ContaInexistenteException, ValorInvalidoException {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numeroConta)) {
				conta.sacar(valor);
			}
		}

	}

}
