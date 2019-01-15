package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public interface BancoGeral {
	 List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException;	
	 BigDecimal consultarSaldo(int numeroConta)throws ContaInexistenteException;	
	 void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor) throws SaldoInsuficienteException, ContaInexistenteException;;	
	 void efetuarDeposito(int numeroConta, BigDecimal valor);	
	 void efetuarSaque(int numeroConta, BigDecimal valor) throws SaldoInsuficienteException;
}
