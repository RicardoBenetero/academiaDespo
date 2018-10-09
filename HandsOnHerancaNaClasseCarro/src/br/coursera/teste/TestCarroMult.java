package br.coursera.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.coursera.CarroDeCorrida;
import br.coursera.CarroMult;
import br.coursera.CarroSoma;

public class TestCarroMult {

	CarroDeCorrida ferrari;

	@Before
	
		
		
        public void inicializaCarro() {
        	
        	ferrari = new CarroMult("teste",1.5,100);
        
		

	}

	@Test
	public void acelerarUmaVez() {

		ferrari.acelerar();
		

		assertEquals(10, ferrari.getVelocidade());

	}
	
	@Test
	public void acelerarDuasVezes() {

		ferrari.acelerar();
		ferrari.acelerar();
		

		assertEquals(15, ferrari.getVelocidade());

	}

	@Test
	public void frear() {

		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();

		ferrari.frear();

		assertEquals(11, ferrari.getVelocidade());

	}
	
	@Test
	public void frearAteZero() {

		ferrari.acelerar();

		ferrari.frear();
		ferrari.frear();
		ferrari.frear();


		ferrari.frear();


		assertEquals(0, ferrari.getVelocidade());

	}
	
	@Test
	public void aceleraAteVelocidadeMaxima() {
		
		for (int i = 0; i<14; i++)

		ferrari.acelerar();

		


		assertEquals(100, ferrari.getVelocidadeMaxima());

	}

}
