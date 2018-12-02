package br.academiaDespo.Banco;

import java.math.BigDecimal;

public interface Conta {
	
	public String getNumero();
	public BigDecimal consultarSaldo();

}
