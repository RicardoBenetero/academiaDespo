package br.coursera;

import java.util.List;

public class TV {
	private static int VOLUME_MAXIMO = 50;
	private static int VOLUME_MINIMO = 0;
	private int volume;
	private List<Integer> canais;
	private boolean ligada = false;
	private Integer canalAtivo = 0;

	public TV(List<Integer> canais) {

		this.canais = canais;

	}

	public boolean liga() {

		ligada = true;
		return ligada;
	}

	public boolean desliga() {

		ligada = false;
		return ligada;
	}

	public int aumentaVolume() {

		if (volume < VOLUME_MAXIMO) {
			this.volume++;

		}

		return volume;
	}

	public int diminuiVolume() {

		if (volume > VOLUME_MINIMO) {
			this.volume--;

		}

		return volume;
	}

	public int mudaCanal(int canal) {
		if (canais.contains(canal)) {
			canalAtivo = canal;

		}
		return canalAtivo;

	}

	public int aumentaCanal() {

		int indiceCanalAtivo = canais.indexOf(canalAtivo);

		if (indiceCanalAtivo < canais.size() - 1)

			canalAtivo = canais.get(indiceCanalAtivo + 1);

		return canalAtivo;

	}

	public int diminuiCanal() {

		int indiceCanalAtivo = canais.indexOf(canalAtivo);

		if (indiceCanalAtivo < canais.size() - 1 && indiceCanalAtivo != 0)

			canalAtivo = canais.get(indiceCanalAtivo - 1);

		return canalAtivo;

	}

}
