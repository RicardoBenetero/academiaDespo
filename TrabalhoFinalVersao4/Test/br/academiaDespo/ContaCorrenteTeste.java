package br.academiaDespo;

import java.math.BigDecimal;

import br.academiaDespo.Banco.Conta;

public class ContaCorrenteTeste implements Conta {

	private String numero;
	private BigDecimal saldo = new BigDecimal("0.0");

	public ContaCorrenteTeste(String numeroConta) {

		this.numero = numeroConta;
	}

	@Override
	public String getNumero() {

		return numero;
	}

	@Override
	public BigDecimal consultarSaldo() {
		return saldo;
	}

}
