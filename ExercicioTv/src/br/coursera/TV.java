package br.coursera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TV {
	private static int volumeMaximo = 50;
	private static int volumeMinimo = 0;
	private int volume;
	private List<Integer> canais;
	private boolean ligada = false;
	private int canalAtivo = 0;

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

		if (volume < volumeMaximo) {
			this.volume++;

		}

		return volume;
	}

	public int diminuiVolume() {

		if (volume > volumeMinimo) {
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

}
