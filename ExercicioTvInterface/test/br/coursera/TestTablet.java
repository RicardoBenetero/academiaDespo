package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTablet {
	
	private List<Integer> musicas;
	private ControleRemoto controleRemoto;
	private Controlavel controlavel;

	@Before
	public void preparaMassa() {

		this.musicas = new ArrayList<Integer>();
	

		this.musicas.add(2);
		this.musicas.add(4);
		this.musicas.add(6);
		this.musicas.add(8);
		this.musicas.add(10);
		this.musicas.add(12);

		
		
		controlavel = new Tablet(musicas);

		controleRemoto = new ControleRemoto(controlavel);

	}

	@Test
	public void deveRetornarLigadaQuandoLiga() {

		boolean TvLigada = true;

		boolean ligada = controleRemoto.liga();

		assertTrue(TvLigada == ligada);

	}

	@Test
	public void deveRetornarDesligadaQuandoDesliga() {

		boolean TvLigada = false;

		boolean ligada = controleRemoto.desliga();

		assertTrue(TvLigada == ligada);

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

	@Test
	public void musicaInformadaDeveSerAAtiva() {

		assertEquals(6, controleRemoto.escolhe(6));

	}

	@Test
	public void deveRetornarZeroQuandoInformadaMusicaInexistente() {

		assertEquals(0, controleRemoto.escolhe(14));

	}

	@Test
	public void deveRetornarProximaMusicaQuandoAvanca() {

		int canalAtivo = controleRemoto.escolhe(6);

		int canal = controleRemoto.avanca();

		assertEquals(8, canal);

	}

	@Test
	public void deveRetornarMusicaAnteriorQuandoRetrocede() {

		int canalAtivo = controleRemoto.escolhe(6);

		int canal = controleRemoto.retrocede();

		assertEquals(4, canal);

	}

	@Test
	public void deveRetornarUltimaMusicaQuandoAvancaEJaEstaNaUltima() {

		int canalAtivo = controleRemoto.escolhe(12);

		int canal = controleRemoto.avanca();

		assertEquals(12, canal);

	}

	@Test
	public void deveRetornarPrimeiraMusicaQuandoRetrocedeEJaEstaNaPrimeira() {

		int canalAtivo = controleRemoto.escolhe(2);

		int canal = controleRemoto.retrocede();

		assertEquals(2, canal);

	}

}



