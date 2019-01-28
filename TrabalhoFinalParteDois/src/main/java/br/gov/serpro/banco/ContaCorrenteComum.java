package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class ContaCorrenteComum implements ContaBancoAlfa {

	private int numero;

	private BigDecimal saldo = new BigDecimal("0.0");

	private List<Extrato> extratos = new ArrayList<Extrato>();

	private int quantidadeOperacoes = 1;

	LocalDate data = LocalDate.now();

	public ContaCorrenteComum(int numeroConta, BigDecimal valorInicial) {

		this.numero = numeroConta;
		this.saldo = valorInicial;

	}

	public int getNumero() {
		// TODO Auto-generated method stub
		return numero;
	}

	public BigDecimal consultarSaldo() throws LimiteDeOperacoesPorDiaAtingidoException {

		if (quantidadeOperacoes <= 3) {

			quantidadeOperacoes++;
			return saldo;

		} else {
			throw new LimiteDeOperacoesPorDiaAtingidoException("Limite diario de operacoes atingido");

		}

	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {

		System.out.println("deposito indisponivel");

	}

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		if (saldo.compareTo(valor) > 0 && quantidadeOperacoes <= 3) {

			saldo = saldo.subtract(valor);

			String operacao = "Saque";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

			quantidadeOperacoes++;

		} else if (saldo.compareTo(valor) < 0 && quantidadeOperacoes <= 3) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else if (saldo.compareTo(valor) > 0 && quantidadeOperacoes > 3) {
			throw new LimiteDeOperacoesPorDiaAtingidoException("Limite diario de operacoes atingido");
		}

	}

	public void insereValorDeTransferencia(BigDecimal valor) {

		if (valor.compareTo(BigDecimal.ZERO) > 0 && quantidadeOperacoes <= 3) {

			saldo = saldo.add(valor);

			String operacao = "Transferencia";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

			quantidadeOperacoes++;

		}

	}

	public List<Extrato> getExtrato() {
		return extratos;
	}
}
