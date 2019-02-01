package br.gov.serpro.bancoBeta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class ContaCorrenteEspecialBancoBeta implements ContaBancoBeta{
	
	private static BigDecimal LIMITE_SALDO_PREMIUM = new BigDecimal("5000.0");
	
	private int numero;

	private BigDecimal saldo = new BigDecimal(0.0);

	private List<Extrato> extratos = new ArrayList<Extrato>();
	
	private CalculaTaxa calculaTaxa = new CalculaTaxa();
	
	LocalDate data = LocalDate.now();

	
	public ContaCorrenteEspecialBancoBeta(int numeroConta) {
		
		
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

				Extrato extrato = new Extrato(data, null,valor , operacao);

				extratos.add(extrato);

				saldo = saldo.add(valor) ;

		 }else {

		 throw new ContaInexistenteException("Conta Inexistente");
		 
		 }
	}

	public void sacar(BigDecimal valor) throws SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		if (this.saldo.add(LIMITE_SALDO_PREMIUM).doubleValue() >= valor.doubleValue()) {

			saldo = saldo.subtract(valor.add(calculaTaxa.calculaTaxaDoSaque(valor)));


			String operacao = "Saque";

			Extrato extrato = new Extrato(data, null, valor, operacao);

			extratos.add(extrato);

		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente");

		}

		
	}

	
	

	public List<Extrato> getExtrato() {
		return extratos;
	}
	public void setQuantidadeOperacoes() {
		
	}

	
}
