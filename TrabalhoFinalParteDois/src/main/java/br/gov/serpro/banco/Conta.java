package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;


public interface Conta {
	
	public int getNumero();
	public BigDecimal consultarSaldo();
	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException;
	public void sacar(BigDecimal valor) throws SaldoInsuficienteException;
	public void insereValorDeTransferencia(BigDecimal valor);
	public List<Extrato> getExtrato();

}
