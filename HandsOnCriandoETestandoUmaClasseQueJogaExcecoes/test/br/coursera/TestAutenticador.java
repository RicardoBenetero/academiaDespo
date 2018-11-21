package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAutenticador {

	@Test
	public void logincomSucesso() throws LoginException {
		
		Autenticador autenticador = new Autenticador();
		
		Usuario ricardo = autenticador.logar("ricardo" , "1234");
		
		assertEquals("ricardo", ricardo.getLogin());
		
	}
	
	@Test(expected = LoginException.class)
	public void logincomFalha() throws LoginException  {
		
		Autenticador autenticador = new Autenticador();
		
		Usuario ricardo = autenticador.logar("ricardo" , "1235");
		
		
	}
	
	@Test
	public void informacaoDoerro()  {
		
		Autenticador autenticador = new Autenticador();
		
		try {
			Usuario ricardo = autenticador.logar("ricardo" , "1235");
			fail();
		} catch (LoginException e) {
			
			assertEquals("ricardo", e.getLogin());
		}
		
		
	}

}
