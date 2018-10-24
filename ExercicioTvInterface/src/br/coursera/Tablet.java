package br.coursera;

import java.util.List;

public class Tablet implements Controlavel {

	private static int VOLUME_MAXIMO = 30;
	private static int VOLUME_MINIMO = 0;

	private int volume;
	private boolean ligada = false;

	public Tablet() {

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

		return 0;

	}

	@Override
	public int retrocede() {

		return 0;

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
	public int escolhe(int dados) {

		return 0;
	}
}
