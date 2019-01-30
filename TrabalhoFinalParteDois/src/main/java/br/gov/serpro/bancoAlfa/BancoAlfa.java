package br.gov.serpro.bancoAlfa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class BancoAlfa implements BancoGeral {

	private final static String NOME = "BANCO ALFA";
	List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

	public BancoAlfa(List<ContaBancoAlfa> contas) {

		this.contas = contas;
	}

	public List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException {

		for (ContaBancoAlfa conta : contas) {
			if (conta.getNumero() == numeroConta) {
				return conta.getExtrato();

			}

		}
		throw new ContaInexistenteException("Conta Inexistente");

	}

	public BigDecimal consultarSaldo(int numeroConta)
			throws ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		for (ContaBancoAlfa conta : contas) {
			if (conta.getNumero() == numeroConta) {
				return conta.consultarSaldo();
			}
		}

		throw new ContaInexistenteException("Conta Inexistente");
	}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		for (ContaBancoAlfa conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);

			}
			if (conta.getNumero() == contaDestino) {
				conta.insereValorDeTransferencia(valor);

			}
		}

	}

	public void efetuarDeposito(int numeroConta, BigDecimal valor) {

	}

	public void efetuarSaque(int numeroConta, BigDecimal valor)
			throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		for (ContaBancoAlfa conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);
			}
		}

	}

}
