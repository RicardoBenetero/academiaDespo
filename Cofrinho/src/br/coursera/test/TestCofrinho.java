package br.coursera.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.Cofrinho;
import br.coursera.Moeda;

public class TestCofrinho {

	@Test
	public void testCofrinho() {
		Cofrinho cofrinho = new Cofrinho();

		Moeda moedaUmReal = new Moeda();
		moedaUmReal.valorMoeda = "moedaUmReal";

		Moeda moedaCinquentaCentavos = new Moeda();
		moedaCinquentaCentavos.valorMoeda = "moedaCinquentaCentavos";

		Moeda moedaVinteECincoCentavos = new Moeda();
		moedaVinteECincoCentavos.valorMoeda = "moedaVinteECincoCentavos";

		Moeda moedaDezCentavos = new Moeda();
		moedaDezCentavos.valorMoeda = "moedaDezCentavos";

		Moeda moedaCincoCentavos = new Moeda();
		moedaCincoCentavos.valorMoeda = "moedaCincoCentavos";

		Moeda moedaUmCentavo = new Moeda();
		moedaUmCentavo.valorMoeda = "moedaUmCentavo";

		Moeda moedaTrintaCentavos = new Moeda();
		moedaTrintaCentavos.valorMoeda = "moedaTrintaCentavos";

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmReal);

		cofrinho.contaNumeroMoedasArmazenadas(moedaUmCentavo);

		cofrinho.contaNumeroMoedasArmazenadas(moedaVinteECincoCentavos);

		cofrinho.contaNumeroMoedasArmazenadas(moedaTrintaCentavos);

		assertEquals(5, cofrinho.getQuantidadeMoedas());
		assertEquals(3, cofrinho.getMoedaUmReal());
		assertEquals(1, cofrinho.getMoedaUmCentavo());
		assertEquals(0, cofrinho.getMoedaCincoCentavos());
		assertEquals(0, cofrinho.getMoedaDezCentavos());
		assertEquals(1, cofrinho.getMoedaVinteECincoCentavos());
		assertEquals(0, cofrinho.getMoedaCinquenta());
		assertEquals("Moeda de maior valor no cofrinho - moeda De Um Real", cofrinho.informaMoedaMaiorValor());




	}

}
