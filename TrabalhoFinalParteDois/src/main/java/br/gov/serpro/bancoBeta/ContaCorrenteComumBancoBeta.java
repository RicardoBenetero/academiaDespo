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
	
	
	private static BigDecimal LIMITE_SALDO_COMUM = new BigDecimal("200.0");

	 private int numero;

	 private BigDecimal saldo = new BigDecimal(0.0);

	 private List<Extrato> extratos = new ArrayList<Extrato>();
	
	 LocalDate data = LocalDate.now();
	 
	 private int quantidadeOperacoes = 0;

     private CalculaTaxa calculaTaxa = new CalculaTaxa();

   
	 public ContaCorrenteComumBancoBeta(int numeroConta) {
		
		
		this.numero = numeroConta;
		
		
	}
	public int getNumero() {
		return numero;
	}

	public BigDecimal consultarSaldo() throws LimiteDeOperacoesPorDiaAtingidoException {
		if (quantidadeOperacoes < 3) {

		quantidadeOperacoes++;
		
			return saldo;

		} else {
			throw new LimiteDeOperacoesPorDiaAtingidoException("Limite diario de operacoes atingido");

		}


	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {
		 if(valor.compareTo(BigDecimal.ZERO) > 0 && quantidadeOperacoes < 3)  {
			 
			 String operacao = "deposito";

				Extrato extrato = new Extrato(data, null, valor, operacao);

				extratos.add(extrato);

				quantidadeOperacoes++;
				


				saldo = saldo.add(valor) ;

		 }else {

		 throw new ContaInexistenteException("Conta Inexistente");
		 
		 }
	}
		
	

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		

			if (this.saldo.add(LIMITE_SALDO_COMUM).doubleValue() >= valor.doubleValue()&& quantidadeOperacoes < 3) {


			saldo = saldo.subtract(calculaTaxa.calculaTaxaDoSaque(valor));
			
			
            
            
			String operacao = "Saque";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

			quantidadeOperacoes++;
			


		} else if (saldo.compareTo(valor) < 0 && quantidadeOperacoes < 3) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else if (saldo.compareTo(valor) > 0 && quantidadeOperacoes > 2) {
			throw new LimiteDeOperacoesPorDiaAtingidoException("Limite diario de operacoes atingido");
		}

	}

		
	public List<Extrato> getExtrato() {
		return extratos;
	}
	public void setQuantidadeOperacoes() {
		this.quantidadeOperacoes ++;;
	}
	
}
