package br.gov.serpro.bancoBeta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.bancoAlfa.ContaBancoAlfa;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;



public class BancoBeta implements BancoGeral {
	
	private final static String NOME = "BANCO BETA";
	List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();
	
	
	public BancoBeta(List<ContaBancoBeta> contas) {
		
		this.contas = contas;

		
	}

	public List<Extrato> consultarExtrato(int numeroConta) throws ContaInexistenteException {
		
		for (ContaBancoBeta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				if(conta instanceof ContaCorrenteComumBancoBeta) {
					
					conta.setQuantidadeOperacoes();

					return conta.getExtrato();
					
					
					}else if(conta instanceof ContaCorrenteEspecialBancoBeta) {
						
						return conta.getExtrato();

					}
				}
			

			}
	

		
		throw new ContaInexistenteException("Conta Inexistente");

	}


	public BigDecimal consultarSaldo(int numeroConta)
			throws ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
			for (ContaBancoBeta conta : contas) {
				if (conta.getNumero() == numeroConta) {
					return conta.consultarSaldo();
				}
			}

			throw new ContaInexistenteException("Conta Inexistente");
		}

	public void efetuarTransferencia(int numeroConta, int contaDestino, BigDecimal valor)
			throws SaldoInsuficienteException, ContaInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		for (ContaBancoBeta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);

			}
			if (conta.getNumero() == contaDestino) {
				
				if(conta instanceof ContaCorrenteComumBancoBeta) {
				conta.realizarDeposito(valor);
				
				conta.setQuantidadeOperacoes();
				
				}else if(conta instanceof ContaCorrenteEspecialBancoBeta) {
					
					conta.realizarDeposito(valor);

				}
			}
		}

	}

	

	public void efetuarDeposito(int numeroConta, BigDecimal valor)throws ContaInexistenteException {
		

		for (ContaBancoBeta conta : contas) {
			if (conta.getNumero() == numeroConta ) {

				conta.realizarDeposito( valor);
				


			}
		}
	}
		
	

	public void efetuarSaque(int numeroConta, BigDecimal valor)
			throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		for (ContaBancoBeta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				conta.sacar(valor);
			}
		}

	}

}
