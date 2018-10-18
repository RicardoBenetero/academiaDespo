package br.coursera.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.coursera.ControleRemoto;
import br.coursera.TV;

public class TestTV {

	List<Integer> canais;
	TV tv;
	ControleRemoto controleRemoto;

	@Before
	public void preparaMassa() {

		this.canais = new ArrayList<Integer>();
		/*
		 * for (int i = 1; i <= 13; i++) {
		 * 
		 * this.canais.add(i);
		 * 
		 * }
		 */

		this.canais.add(2);
		this.canais.add(4);
		this.canais.add(6);
		this.canais.add(8);
		this.canais.add(10);
		this.canais.add(12);

		tv = new TV(canais);

		controleRemoto = new ControleRemoto(tv);

	}

	@Test
	public void testLigaTV() {

		controleRemoto.ligaTv();

		assertTrue(tv.tvEstaLigada().equals("ligada"));

	}

	@Test
	public void testDesligaTV() {

		controleRemoto.desligaTv();

		assertTrue(tv.tvEstaLigada().equals("desligada"));

	}

	@Test
	public void testAumentaVolumeTVDuasVezes() {

		int volume = 0;
		for (int i = 1; i <= 2; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(2, volume);
	}

	@Test
	public void testAumentaVolumeTVAcimaLimiteDeveRetornarSempreOLimite() {
		int volume = 0;
		for (int i = 1; i <= 51; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(50, volume);

	}

	@Test
	public void testDiminuiVolumeTVAbaixoLimiteDeveRetornarSempreOLimite() {
		int volume = 0;
		testAumentaVolumeTVDuasVezes();

		for (int i = 1; i <= 3; i++) {

			volume = controleRemoto.diminuiVolume();
		}
		assertEquals(0, volume);

	}

	@Test
	public void testDiminuiVolumeTVUmaVez() {
		int volume = 0;
		testAumentaVolumeTVDuasVezes();

		volume = controleRemoto.diminuiVolume();

		assertEquals(1, volume);

	}

	@Test
	public void testMudaCanalTvCanalInformadoDeveSerOAtivo() {

		assertEquals(6, controleRemoto.mudaCanal(6));

	}

	@Test
	public void testMudaCanalTvParaCanalInexistenteDeveRetornarZero() {

		assertEquals(0, controleRemoto.mudaCanal(14));

	}

}
