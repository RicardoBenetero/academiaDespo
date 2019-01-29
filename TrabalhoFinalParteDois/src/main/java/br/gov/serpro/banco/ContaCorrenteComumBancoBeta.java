package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class ContaCorrenteComumBancoBeta implements ContaBancoBeta{

	public int getNumero() {
		// TODO Auto-generated method stub
		return 0;
	}

	public BigDecimal consultarSaldo() throws LimiteDeOperacoesPorDiaAtingidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// TODO Auto-generated method stub
		
	}

	public void insereValorDeTransferencia(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	public List<Extrato> getExtrato() {
		// TODO Auto-generated method stub
		return null;
	}

}
