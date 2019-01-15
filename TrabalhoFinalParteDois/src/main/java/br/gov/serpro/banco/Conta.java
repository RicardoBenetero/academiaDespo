package br.gov.serpro.banco;

import java.math.BigDecimal;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;


public interface Conta {
	
	public String getNumero();
	public BigDecimal consultarSaldo();
	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException;
	public void sacar(BigDecimal valor);

}
