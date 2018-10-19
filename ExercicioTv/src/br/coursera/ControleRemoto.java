package br.coursera;

public class ControleRemoto {

	private TV tv;

	public ControleRemoto(TV tv) {

		this.tv = tv;

	}

	public int aumentaVolume() {

		return tv.aumentaVolume();

	}

	public int diminuiVolume() {

		return tv.diminuiVolume();

	}

	public boolean ligaTv() {

		return tv.liga();

	}

	public boolean desligaTv() {

		return tv.desliga();

	}

	public int mudaCanal(int canal) {

		return tv.mudaCanal(canal);

	}

}
