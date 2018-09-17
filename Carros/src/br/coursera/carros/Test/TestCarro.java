package br.coursera.carros.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.coursera.carros.Carro;

public class TestCarro {

	Carro ferrari;

	@Before
	public void preparaDados() {

		ferrari = new Carro();
		ferrari.potencia = 10;
		ferrari.nome = "Ferrari";
		ferrari.velocidade = 0;

		Carro fusca = new Carro();
		fusca.potencia = 10;
		fusca.nome = "Fusca";
		fusca.velocidade = 0;

		Carro ferrariVermelha = new Carro();
		ferrariVermelha.potencia = 10;
		ferrariVermelha.nome = "Ferrari";
		ferrariVermelha.velocidade = 0;

	}

	@Test
	public void acelerar() {

		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();

		assertEquals(30, ferrari.getVelocidade());

	}

	@Test
	public void frear() {

		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();

		ferrari.frear();

		assertEquals(15, ferrari.getVelocidade());

	}

}
