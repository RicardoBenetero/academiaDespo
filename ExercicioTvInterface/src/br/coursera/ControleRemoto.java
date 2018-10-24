package br.coursera;

public class ControleRemoto implements Controlavel {
	
	Controlavel controlavel;
	
	
	public ControleRemoto(Controlavel controlavel) {
		
		this.controlavel = controlavel;
		
	}

	@Override
	public int aumentaVolume() {
		return controlavel.aumentaVolume();		
	}

	@Override
	public int diminuiVolume() {
		return controlavel.diminuiVolume();
		
	}

	@Override
	public int avanca() {
		return controlavel.avanca();
		
	}

	@Override
	public int retrocede() {
		return controlavel.retrocede();
		
	}

	@Override
	public boolean liga() {
		return controlavel.liga();
		
	}

	@Override
	public boolean desliga() {
		return controlavel.desliga();
		
	}

	@Override
	public int escolhe(int opcaoTeclada) {
	
		return controlavel.escolhe(opcaoTeclada);
	}

}
