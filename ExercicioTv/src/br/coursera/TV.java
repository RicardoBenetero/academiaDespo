package br.coursera;

import java.util.List;

public class TV {

	private List<Integer> canais;
	private int volume = 0;
	private boolean ligada = false;
	private int indiceCanalAtivo = 0;

	public TV(List<Integer> canais) {

		this.canais = canais;

	}

	public void liga() {

		ligada = true;
	}

	public void desliga() {

		ligada = false;
	}

	public void aumentaVolume() {
		while (volume >= 50) {
			this.volume++;
		}

		System.out.println("volume atingiu limite maximo");

	}

	public void diminuiVolume() {

		while (volume < 0) {
			this.volume--;
		}

		System.out.println("volume atingiu limite minimo");

	}

	public void mudaCanal(int canal) {
		if (canais.contains(canal)) {
			indiceCanalAtivo = canais.get(canal);
		} else {

			System.out.println("canal inexistente");
		}

	}

	public String tvEstaLigada() {

		if (ligada == true)
			return "ligada";
		return "desligada";

	}

}
