package br.gov.serpro.banco;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.Conta;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;



public class BancoAlfa implements BancoGeral {

	private final static String NOME = "BANCO ALFA";
	List<Conta> contas = new ArrayList<Conta>();

	public BancoAlfa(List<Conta> contas) {

		this.contas = contas;
	}

	public List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal consultarSaldo(int numeroConta) throws ContaInexistenteException {
		for (Conta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				return conta.consultarSaldo();
			}
		}

		throw new ContaInexistenteException("Conta Inexistente");
	}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException {
		for (Conta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);
				
			}
			if (conta.getNumero() == contaDestino) {
				conta.insereValorDeTransferencia(valor);
				
			}
		}


		
	}

	public void efetuarDeposito(int numeroConta, BigDecimal valor) {
		
	}

	public void efetuarSaque(int numeroConta, BigDecimal valor) throws SaldoInsuficienteException {
		
		
		for (Conta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);
			}
		}
		
	}

	
}

