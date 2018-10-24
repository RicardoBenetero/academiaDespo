package br.coursera;

import java.util.List;

public class Tablet implements Controlavel {

	private static int VOLUME_MAXIMO = 30;
	private static int VOLUME_MINIMO = 0;
	private List<Integer> musicas;
	private int volume;
	private int avanca;
	private int retrocede;
	private boolean ligada = false;
	private Integer musicaAtiva = 0;


	public Tablet(List<Integer> musicas) {

		this.musicas = musicas;

	}

	@Override
	public int aumentaVolume() {
		if (volume < VOLUME_MAXIMO) {
			this.volume++;

		}

		return volume;
	}

	@Override
	public int diminuiVolume() {
		if (volume > VOLUME_MINIMO) {
			this.volume--;

		}

		return volume;

	}

	@Override
	public int avanca() {
		int indiceMusicaAtiva = musicas.indexOf(musicaAtiva);

		if (indiceMusicaAtiva < musicas.size() - 1)

			musicaAtiva = musicas.get(indiceMusicaAtiva + 1);

		return musicaAtiva;

	}

	@Override
	public int retrocede() {
		int indiceMusicaAtiva = musicas.indexOf(musicaAtiva);

		if (indiceMusicaAtiva < musicas.size() - 1 && indiceMusicaAtiva != 0)

			musicaAtiva = musicas.get(indiceMusicaAtiva - 1);

		return musicaAtiva;

	}

	@Override
	public boolean liga() {
		ligada = true;
		return ligada;

	}

	@Override
	public boolean desliga() {
		ligada = false;
		return ligada;
	}

	public int mudaMusica(int musica) {
		if (musicas.contains(musica)) {
			musicaAtiva = musica;

		}
		return musicaAtiva;

	}

	@Override
	public int escolhe(int musica) {
		if (musicas.contains(musica)) {
			musicaAtiva = musica;

		}
		return musicaAtiva;
	}
}
