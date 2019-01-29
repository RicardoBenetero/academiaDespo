package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class ContaCorrenteEspecialBancoBeta implements ContaBancoBeta{
	
	private static BigDecimal LIMITE_SALDO_PREMIUM = new BigDecimal("5000.0");

	private int numero;

	private BigDecimal saldo = new BigDecimal(0.0);

	private List<Extrato> extratos = new ArrayList<Extrato>();
	
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
		
		
	System.out.println("passou no realizar deposito do contaEspecialBancoBeta antes do if");
		 if(valor.compareTo(BigDecimal.ZERO) > 0) {
			 
				System.out.println("passou no realizar deposito do contaEspecialBancoBeta depois do if");

			 
				String operacao = "Deposito";

				Extrato extrato = new Extrato(data, valor, null, operacao);

				extratos.add(extrato);

				saldo = saldo.add(valor) ;
				System.out.println("passou no realizar deposito do contaEspecialBancoBeta depois saldo.add");

		 }else {
				System.out.println("passou no realizar deposito do contaEspecialBancoBeta depois else");

		 throw new ContaInexistenteException("Conta Inexistente");
		 
		 }
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
