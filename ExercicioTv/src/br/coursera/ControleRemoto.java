package br.coursera;

public class ControleRemoto {

	TV tv;

	public ControleRemoto(TV tv) {

		this.tv = tv;

	}

	public int aumentaVolume() {

		return tv.aumentaVolume();

	}

	public int diminuiVolume() {

	return	tv.diminuiVolume();

	}

	public void ligaTv() {

		tv.liga();

	}

	public void desligaTv() {

		tv.desliga();

	}
	
	public int mudaCanal(int canal) {
		
		return tv.mudaCanal(canal);
		
	}

}
