package br.gov.serpro.banco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;


public class ContaCorrenteEspecial implements Conta {

	private static BigDecimal LIMITE_SALDO_PREMIUM = new BigDecimal("1000.0");
	
	private int numero;
	
	private BigDecimal saldo = new BigDecimal("0.0");
	
	private List<Extrato> extratos = new ArrayList<Extrato>();
    


	public ContaCorrenteEspecial(int numeroConta, BigDecimal valorInicial) {

		this.numero = numeroConta;
		this.saldo = valorInicial;

	}

	public int getNumero() {
		// TODO Auto-generated method stub
		return numero;
	}

	public BigDecimal consultarSaldo() {
		return saldo;
	}

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException {
		
		System.out.println("deposito indisponivel");
		
      }


	public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
		
		try {
			//if (saldo.compareTo(this.saldo.add(LIMITE_SALDO_PREMIUM)) > 0) {
			
			if (saldo.compareTo(valor) > 0 ) {
            
				saldo = saldo.subtract(valor);
				
				LocalDate data = LocalDate.now();
				
				Extrato extrato = new Extrato(data,valor, null);
				
				extratos.add(extrato);

			} else {
				throw new SaldoInsuficienteException("Saldo insuficiente");

			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	public void insereValorDeTransferencia(BigDecimal valor) {
		 if(valor.compareTo(BigDecimal.ZERO) > 0) {


				saldo = saldo.add(valor) ;
				
               
          
		
	}
		 
	}

	public List<Extrato> getExtrato() {
		return extratos;
	}
}

	
