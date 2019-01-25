package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Extrato {

	//private String data;
	private LocalDate data;
	
	private BigDecimal credito = new BigDecimal("0.0");

	private BigDecimal debito = new BigDecimal("0.0");

	private String operacao;

	public Extrato(LocalDate data, BigDecimal credito, BigDecimal debito, String operacao) {
		this.data = data;
		this.credito = credito;
		this.debito = debito;
		this.operacao = operacao;
	}

	public LocalDate getData() {
		return data;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public BigDecimal getDebito() {
		return debito;
	}

	public String getOperacao() {
		return operacao;
	}

	

}
