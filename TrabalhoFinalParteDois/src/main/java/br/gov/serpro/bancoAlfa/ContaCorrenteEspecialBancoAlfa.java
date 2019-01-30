package br.gov.serpro.bancoAlfa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;

public class ContaCorrenteEspecialBancoAlfa implements ContaBancoAlfa {

	private static BigDecimal LIMITE_SALDO_PREMIUM = new BigDecimal("1000.0");

	private int numero;

	private BigDecimal saldo = new BigDecimal("0.0");

	private List<Extrato> extratos = new ArrayList<Extrato>();

	public ContaCorrenteEspecialBancoAlfa(int numeroConta, BigDecimal valorInicial) {

		this.numero = numeroConta;
		this.saldo = valorInicial;

	}

	public int getNumero() {
		// TODO Auto-generated method stub
		return numero;
	}

	public BigDecimal consultarSaldo() {
		return saldo;
	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {

		System.out.println("deposito indisponivel");

	}

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException {

		if (this.saldo.add(LIMITE_SALDO_PREMIUM).doubleValue() >= valor.doubleValue()) {

			saldo = saldo.subtract(valor);

			LocalDate data = LocalDate.now();

			String operacao = "Saque";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

	}

	public void insereValorDeTransferencia(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) > 0) {

			saldo = saldo.add(valor);

			LocalDate data = LocalDate.now();

			String operacao = "Transferencia";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

		}

	}

	public List<Extrato> getExtrato() {
		return extratos;
	}
}
