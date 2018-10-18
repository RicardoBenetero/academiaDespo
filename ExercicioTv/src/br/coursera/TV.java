package br.coursera;

import java.util.List;

public class TV {

	private List<Integer> canais;
	private int volume = 0;
	private boolean ligada = false;
	private int canalAtivo = 0;

	public TV(List<Integer> canais) {

		this.canais = canais;

	}

	public void liga() {

		ligada = true;
	}

	public void desliga() {

		ligada = false;
	}

	public int aumentaVolume() {

		if (volume < 50) {
			this.volume++;

		}

		return volume;
	}

	public int diminuiVolume() {

		if (volume > 0) {
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

	public String tvEstaLigada() {

		if (ligada == true)
			return "ligada";
		return "desligada";

	}

}
