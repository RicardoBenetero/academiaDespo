package br.coursera.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.coursera.ContaCorrente;

public class TestContaCorrente {
	ContaCorrente cc;
	
	@Before
	
	public void inicializacontacorrente() {
		
		
		cc = new ContaCorrente();
		cc.depositar(200);

	}
	
	

	@Test
	public void deposito() {
		
		
		
		assertEquals(200,cc.getSaldo());

	}
	
	@Test
	public void saque() {
		
 		
		int valorSacado = cc.sacar(50);
		assertEquals(150,cc.getSaldo());
		assertEquals(50, valorSacado);


	}
	
	@Test
	public void saqueMaiorQueSaldo() {
		
 		
		int valorSacado = cc.sacar(250);
		assertEquals(200,cc.getSaldo());
		assertEquals(0, valorSacado);


	}

}
