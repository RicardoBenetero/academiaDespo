package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSom {

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

		
		
		controlavel = new Som(musicas);

		controleRemoto = new ControleRemoto(controlavel);

	}

	@Test
	public void deveRetornarLigadaQuandoLigaSom() {

		boolean ligado = true;

		boolean ligada = controleRemoto.liga();

		assertTrue(ligado == ligada);

	}

	@Test
	public void deveRetornarDesligadaQuandoDesligaSom() {

		boolean ligado = false;

		boolean ligada = controleRemoto.desliga();

		assertTrue(ligado == ligada);

	}

	@Test
	public void testAumentaVolumeSomDuasVezes() {

		int volume = 0;
		for (int i = 1; i <= 2; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(2, volume);
	}

	@Test
	public void deveRetornarSempreOLimiteQuandoAumentaVolumeSomAcimaLimite() {
		int volume = 0;
		for (int i = 1; i <= 151; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(150, volume);

	}

	@Test
	public void deveRetornarSempreOLimiteQuandoDiminuiVolumeSomAbaixoLimite() {
		int volume = 0;
		testAumentaVolumeSomDuasVezes();

		for (int i = 1; i <= 3; i++) {

			volume = controleRemoto.diminuiVolume();
		}
		assertEquals(0, volume);

	}

	@Test
	public void testDiminuiVolumeUmaVez() {
		int volume = 0;
		testAumentaVolumeSomDuasVezes();

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

		controleRemoto.escolhe(6);

		int musica = controleRemoto.avanca();

		assertEquals(8, musica);

	}

	@Test
	public void deveRetornarMusicaAnteriorQuandoRetrocede() {

		controleRemoto.escolhe(6);

		int musica = controleRemoto.retrocede();

		assertEquals(4, musica);

	}

	@Test
	public void deveRetornarUltimaMusicaQuandoAvancaEJaEstaNaUltima() {

		controleRemoto.escolhe(12);

		int musica = controleRemoto.avanca();

		assertEquals(12, musica);

	}

	@Test
	public void deveRetornarPrimeiraMusicaQuandoRetrocedeEJaEstaNaPrimeira() {

	    controleRemoto.escolhe(2);

		int musica = controleRemoto.retrocede();

		assertEquals(2, musica);

	}

}



