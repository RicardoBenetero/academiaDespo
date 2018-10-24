package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTablet {

	private ControleRemoto controleRemoto;
	private Controlavel controlavel;

	@Before
	public void preparaMassa() {

		controlavel = new Tablet();

		controleRemoto = new ControleRemoto(controlavel);

	}

	@Test
	public void deveRetornarLigadaQuandoLiga() {

		boolean ligado = true;

		boolean ligada = controleRemoto.liga();

		assertTrue(ligado == ligada);

	}

	@Test
	public void deveRetornarDesligadaQuandoDesliga() {

		boolean ligado = false;

		boolean ligada = controleRemoto.desliga();

		assertTrue(ligado == ligada);

	}

	@Test
	public void testAumentaVolumeDuasVezes() {

		int volume = 0;
		for (int i = 1; i <= 2; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(2, volume);
	}

	@Test
	public void deveRetornarSempreOLimiteQuandoAumentaVolumeAcimaLimite() {
		int volume = 0;
		for (int i = 1; i <= 31; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(30, volume);

	}

	@Test
	public void deveRetornarSempreOLimiteQuandoDiminuiVolumeAbaixoLimite() {
		int volume = 0;
		testAumentaVolumeDuasVezes();

		for (int i = 1; i <= 3; i++) {

			volume = controleRemoto.diminuiVolume();
		}
		assertEquals(0, volume);

	}

	@Test
	public void testDiminuiVolumeUmaVez() {
		int volume = 0;
		testAumentaVolumeDuasVezes();

		volume = controleRemoto.diminuiVolume();

		assertEquals(1, volume);

	}

}
