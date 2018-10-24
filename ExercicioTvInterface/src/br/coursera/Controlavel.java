package br.coursera;

public interface Controlavel {

	public int aumentaVolume();

	public int diminuiVolume();
	
	public int avanca();
	
	public int retrocede();

	public boolean liga();

	public boolean desliga();
	
	public int escolhe(int opcaoTeclada);

}
