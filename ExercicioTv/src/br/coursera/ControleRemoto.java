package br.coursera;

public class ControleRemoto {

	TV tv;

	public ControleRemoto(TV tv) {

		this.tv = tv;

	}

	public void aumentaVolume() {

		tv.aumentaVolume();

	}

	public void diminuiVolume() {

		tv.diminuiVolume();

	}

	public void ligaTv() {

		tv.liga();

	}

	public void desligaTv() {

		tv.desliga();

	}
	
	public void mudaCanal(int canal) {
		
		tv.mudaCanal(canal);
		
	}

}
