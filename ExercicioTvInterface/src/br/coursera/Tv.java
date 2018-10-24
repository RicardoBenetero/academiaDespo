package br.coursera;

import java.util.List;

public class Tv implements Controlavel {

	private static int VOLUME_MAXIMO = 50;
	private static int VOLUME_MINIMO = 0;
	private int volume;
	private List<Integer> canais;
	private boolean ligada = false;
	private Integer canalAtivo = 0;

	public Tv(List<Integer> canais) {

		this.canais = canais;

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
		int indiceCanalAtivo = canais.indexOf(canalAtivo);

		if (indiceCanalAtivo < canais.size() - 1)

			canalAtivo = canais.get(indiceCanalAtivo + 1);

		return canalAtivo;

	}

	@Override
	public int retrocede() {
		int indiceCanalAtivo = canais.indexOf(canalAtivo);

		if (indiceCanalAtivo < canais.size() - 1 && indiceCanalAtivo != 0)

			canalAtivo = canais.get(indiceCanalAtivo - 1);

		return canalAtivo;

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
	@Override
	public int escolhe(int canal) {
		if (canais.contains(canal)) {
			canalAtivo = canal;

		}
		return canalAtivo;

	}

	

	

}
