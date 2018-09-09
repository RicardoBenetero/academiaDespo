package br.coursera;

public class Principal {

	public static void main(String[] args) {
		Somador somador1 = new Somador();
		somador1.nome = "Somador1";
		Somador somador2 = new Somador();
		somador2.nome = "Somador2";
		Somador somador3 = new Somador();
		somador3.nome = "Somador3";

		for (int i = 0; i < 3; i++) {
			somador1.somar();
			somador2.somar();
            somador3.somar();
            
            somador1.imprimir();
            somador2.imprimir();
            somador3.imprimir();


		}
	}

}
