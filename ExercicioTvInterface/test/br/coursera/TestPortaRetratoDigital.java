package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestPortaRetratoDigital {

	private List<Integer> musicas;
	private List<Integer> fotos;
	private ControleRemoto controleRemoto;
	private Controlavel controlavel;

	@Before
	public void preparaMassa() {

		this.musicas = new ArrayList<Integer>();
		this.fotos = new ArrayList<Integer>();

	

		this.musicas.add(2);
		this.musicas.add(4);
		this.musicas.add(6);
		this.musicas.add(8);
		this.musicas.add(10);
		this.musicas.add(12);
		
		this.fotos.add(1);
		this.fotos.add(2);
		this.fotos.add(3);
		this.fotos.add(4);
		this.fotos.add(5);
		this.fotos.add(6);

		
		
		controlavel = new PortaRetratoDigital(musicas,fotos);

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
		for (int i = 1; i <= 21; i++) {

			volume = controleRemoto.aumentaVolume();
		}
		assertEquals(20, volume);

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
	public void testDiminuiVolumeTVUmaVez() {
		int volume = 0;
		testAumentaVolumeDuasVezes();

		volume = controleRemoto.diminuiVolume();

		assertEquals(1, volume);

	}

	@Test
	public void fotoInformadaDeveSerAAtiva() {

		assertEquals(6, controleRemoto.escolhe(6));

	}

	@Test
	public void deveRetornarZeroQuandoInformadaFotoInexistente() {

		assertEquals(0, controleRemoto.escolhe(14));

	}

	@Test
	public void deveRetornarProximaFotoQuandoAvanca() {

		controleRemoto.escolhe(5);

		int foto = controleRemoto.avanca();

		assertEquals(6, foto);

	}

	@Test
	public void deveRetornarMusicaAnteriorQuandoRetrocede() {

		controleRemoto.escolhe(6);

		int foto = controleRemoto.retrocede();

		assertEquals(5, foto);

	}

	@Test
	public void deveRetornarUltimaFotoQuandoAvancaEJaEstaNaUltima() {

		controleRemoto.escolhe(6);

		int foto = controleRemoto.avanca();

		assertEquals(6, foto);

	}

	@Test
	public void deveRetornarPrimeiraFotoQuandoRetrocedeEJaEstaNaPrimeira() {

		controleRemoto.escolhe(1);

		int foto = controleRemoto.retrocede();

		assertEquals(1, foto);

	}

}




