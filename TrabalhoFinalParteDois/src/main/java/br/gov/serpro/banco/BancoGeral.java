package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public interface BancoGeral {
	 List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException;	
	 BigDecimal consultarSaldo(int numeroConta)throws ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException;	
	 void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor) throws SaldoInsuficienteException, ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException;	
	 void efetuarDeposito(int numeroConta, BigDecimal valor) throws ContaInexistenteException;	
	 void efetuarSaque(int numeroConta, BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException;
}
