package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;


public interface ContaBancoAlfa {
	
	public int getNumero();
	public BigDecimal consultarSaldo() throws LimiteDeOperacoesPorDiaAtingidoException;
	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException;
	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException;
	public void insereValorDeTransferencia(BigDecimal valor);
	public List<Extrato> getExtrato();

}
