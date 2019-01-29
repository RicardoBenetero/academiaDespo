package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

 import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;



public class BancoBeta implements BancoGeral {
	
	private final static String NOME = "BANCO BETA";
	List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();
	
	
	public BancoBeta(List<ContaBancoBeta> contas) {
		for (ContaBancoBeta conta : contas) {
	
		System.out.println("numero conta no construtor " + conta.getNumero());
		}
		this.contas = contas;

		for (ContaBancoBeta conta : contas) {
			
			System.out.println("numero conta no construtor " + conta.getNumero());
			}
		
		
	}

	public List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal consultarSaldo(int numeroConta)
			throws ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		System.out.println("passou no consultar saldo banco beta antes do for");
			for (ContaBancoBeta conta : contas) {
				if (conta.getNumero() == numeroConta) {
					return conta.consultarSaldo();
				}
			}

			throw new ContaInexistenteException("Conta Inexistente");
		}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		// TODO Auto-generated method stub
		
	}

	public void efetuarDeposito(int numeroConta, BigDecimal valor)throws ContaInexistenteException {
		
		System.out.println("passou no efetuar deposito banco beta antes do for");

		for (ContaBancoBeta conta : contas) {
			if (conta.getNumero() == numeroConta ) {
				System.out.println("passou no efetuar deposito banco beta depois do for");

				conta.realizarDeposito( valor);
				
				System.out.println("passou no efetuar deposito banco beta depois do if");


			}
		}
	}
		
	

	public void efetuarSaque(int numeroConta, BigDecimal valor)
			throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// TODO Auto-generated method stub
		
	}

}
