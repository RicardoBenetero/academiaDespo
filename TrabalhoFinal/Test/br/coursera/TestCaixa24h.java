package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaixa24h {

	@Test
	public void deveraRetornarSaldo() {
		
		
		Banco banco = new Banco();
		
		//Cliente cliente1 = new Cliente(conta,"Ana");
		
	
		
		Conta conta = new ContaCorrente( "1234");
		
		Cliente cliente1 = new Cliente(conta,"Ana");
		
		conta.realizarDeposito(200.00);
		
		banco.clientes.add(cliente1);
		
		Caixa24h  atm = new Caixa24h(banco);
		
		atm.consultarSaldo(cliente1);
		
		Conta conta2 = new ContaCorrente( "1234");
		
		double delta = 0.01;
		
		assertEquals(200.00,conta.consultarSaldo(),delta );
		
	}

}
