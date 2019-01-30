package br.gov.serpro.bancoBeta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class ContaCorrenteComumBancoBeta implements ContaBancoBeta{
	
	
	
	 private int numero;

	 private BigDecimal saldo = new BigDecimal(0.0);

	 private List<Extrato> extratos = new ArrayList<Extrato>();
	
	 LocalDate data = LocalDate.now();
	 
	 private int quantidadeOperacoes = 1;

     private CalculaTaxa calculaTaxa = new CalculaTaxa();

   
	 public ContaCorrenteComumBancoBeta(int numeroConta) {
		
		
		this.numero = numeroConta;
		
		
	}
	public int getNumero() {
		return numero;
	}

	public BigDecimal consultarSaldo() throws LimiteDeOperacoesPorDiaAtingidoException {
		return saldo;

	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {
		 if(valor.compareTo(BigDecimal.ZERO) > 0) {
			 

			 
				String operacao = "Deposito";

				Extrato extrato = new Extrato(data, valor, null, operacao);

				extratos.add(extrato);

				saldo = saldo.add(valor) ;

		 }else {

		 throw new ContaInexistenteException("Conta Inexistente");
		 
		 }
	}
		
	

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		if (saldo.compareTo(valor) > 0 && quantidadeOperacoes <= 2) {

			saldo = saldo.subtract(valor.add(calculaTaxa.calculaTaxaDoSaque(valor)));

			String operacao = "Saque";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

			quantidadeOperacoes++;

		} else if (saldo.compareTo(valor) < 0 && quantidadeOperacoes <= 2) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else if (saldo.compareTo(valor) > 0 && quantidadeOperacoes > 2) {
			throw new LimiteDeOperacoesPorDiaAtingidoException("Limite diario de operacoes atingido");
		}

	}

		
	

	public void insereValorDeTransferencia(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	public List<Extrato> getExtrato() {
		// TODO Auto-generated method stub
		return null;
	}

}
