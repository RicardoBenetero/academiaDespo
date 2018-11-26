package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaixa24h {

	@Test
	public void deveraRetornarSaldo() {
		
		
		Banco banco = new Banco();
		
		Cliente cliente1 = new Cliente();
		
		Conta conta = new Conta(cliente1, "1234");
		
		conta.realizarDeposito(200.00);
		
		banco.clientes.add(cliente1);
		
		Caixa24h  atm = new Caixa24h(banco);
		
		atm.consultarSaldo(cliente1);
		
		 assertEquals(200.00,conta.consultarSaldo() );
		
	}

}
