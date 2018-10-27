package br.coursera.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.Calcula;

public class TestCalcula {

	@Test
	public void retornaMaiorNumero() {
		
		assertEquals(963, Calcula.retornaMaiorNumero(569, 963));
		
		
	}
	
	@Test
	public void retornaTemperaturaConvertidaDeCelsiusParafahrenheit() {
		
		assertEquals(59.0, Calcula.retornaTemperaturaConvertidaDeCelsiusParafahrenheit(15));
		
		
	}

	@Test
	public void formataCPF() {
		
		assertEquals("235.698.796-74",Calcula.formataCPF("23569879674"));

		
		
	}
	
	@Test
	public void retornaNumeroAleatorio() {
		
		int numeroAleatorio = Calcula.retornaNumeroAleatorio(1, 4);
		assertTrue( numeroAleatorio >= 1 && numeroAleatorio <= 4);

		
		
	}


}
