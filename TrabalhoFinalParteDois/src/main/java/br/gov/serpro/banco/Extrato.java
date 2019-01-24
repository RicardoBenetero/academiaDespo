package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Extrato {

	//private String data;
	private LocalDate data;
	
	private BigDecimal credito = new BigDecimal("0.0");

	private BigDecimal debito = new BigDecimal("0.0");

	

	public Extrato(LocalDate data, BigDecimal credito, BigDecimal debito) {
		this.data = data;
		this.credito = credito;
		this.debito = debito;
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
	
	
	

}
