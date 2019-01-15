package br.gov.serpro.banco;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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
			if (conta.getNumero().equals(numeroConta)) {
				return conta.consultarSaldo();
			}
		}

		throw new ContaInexistenteException("Conta Inexistente");
	}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException {
		// TODO Auto-generated method stub
		
	}

	public void efetuarDeposito(int numeroConta, BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	public void efetuarSaque(int numeroConta, BigDecimal valor) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		
	}

	
}

