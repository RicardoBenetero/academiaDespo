package br.gov.serpro.caixa24h;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.BancoInexistenteException;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class CaixaVinteQuatroHoras {

	private BancoGeral banco;

	public CaixaVinteQuatroHoras(BancoGeral banco) throws BancoInexistenteException {
		if (banco == null) {
			throw new BancoInexistenteException("Banco inexistente");
		}
		this.banco = banco;
	}

	public List<Extrato> consultaExtrato(int numeroConta) throws ContaInexistenteException {
		return banco.consultarExtrato(numeroConta);
	}

	public BigDecimal consultaSaldo(int numeroConta)
			throws ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		return banco.consultarSaldo(numeroConta);
	}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		banco.efetuarTransferencia(numeroConta, contaDestino, valor);

	}

	public void efetuarDeposito(int numeroConta, BigDecimal valor) throws ContaInexistenteException {
		banco.efetuarDeposito(numeroConta, valor);
	}

	public void efetuarSaque(int numeroConta, BigDecimal valor)
			throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		banco.efetuarSaque(numeroConta, valor);
	}
}
