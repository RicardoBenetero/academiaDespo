package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.coursera.ControleRemoto;
import br.coursera.TV;

public class TestTV {

	private List<Integer> canais;
	private TV tv;
	private ControleRemoto controleRemoto;

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
	public void deveRetornarLigadaQuandoLigaTV() {

		boolean TvLigada = true;

		boolean ligada = controleRemoto.ligaTv();

		assertTrue(TvLigada == ligada);

	}

	@Test
	public void deveRetornarDesligadaQuandoDesligaTV() {

		boolean TvLigada = false;

		boolean ligada = controleRemoto.desligaTv();

		assertTrue(TvLigada == ligada);

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
	public void deveRetornarSempreOLimiteQuandoAumentaVolumeTVAcimaLimite() {
		int volume = 0;
		for (int i = 1; i <= 51; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(50, volume);

	}

	@Test
	public void deveRetornarSempreOLimiteQuandoDiminuiVolumeTVAbaixoLimite() {
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
	public void canalInformadoDeveSerOAtivo() {

		assertEquals(6, controleRemoto.mudaCanal(6));

	}

	@Test
	public void deveRetornarZeroQuandoInformadoCanalInexistente() {

		assertEquals(0, controleRemoto.mudaCanal(14));

	}

	@Test
	public void deveRetornarProximoCanalQuandoaumentaCanal() {

		int canalAtivo = controleRemoto.mudaCanal(6);

		int canal = controleRemoto.aumetaCanal();

		assertEquals(8, canal);

	}

	@Test
	public void deveRetornarCanalAnteriorQuandoDiminuiCanal() {

		int canalAtivo = controleRemoto.mudaCanal(6);

		int canal = controleRemoto.diminuiCanal();

		assertEquals(4, canal);

	}

	@Test
	public void deveRetornarUltimoCanalQuandoAumentaEJaEstaNoUltimo() {

		int canalAtivo = controleRemoto.mudaCanal(12);

		int canal = controleRemoto.aumetaCanal();

		assertEquals(12, canal);

	}

	@Test
	public void deveRetornarPrimeiroCanalQuandoDiminueEJaEstaNoPrimeiro() {

		int canalAtivo = controleRemoto.mudaCanal(2);

		int canal = controleRemoto.diminuiCanal();

		assertEquals(2, canal);

	}

}
