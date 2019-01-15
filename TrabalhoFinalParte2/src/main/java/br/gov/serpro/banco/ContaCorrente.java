package br.gov.serpro.banco;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;


public class ContaCorrente implements Conta {

	private String numero;
	private BigDecimal saldo = new BigDecimal("0.0");
	
	private List<String> transacoesEfetuadas = new ArrayList<String>();

	private String insereTransacaoNoExtrato;


	public ContaCorrente(String numeroConta) {

		this.numero = numeroConta;
	}


	public String getNumero() {
		// TODO Auto-generated method stub
		return null;
	}


	public BigDecimal consultarSaldo() {
		return saldo;
	}


	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {
		// TODO Auto-generated method stub
		
	}


	public void sacar(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}


}