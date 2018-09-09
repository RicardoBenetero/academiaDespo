package br.coursera;

public class Principal {

	public static void main(String[] args) {

		Aluno ana = new Aluno();

		ana.bim1 = 70;
		ana.bim2 = 60;
		ana.bim3 = 80;
		ana.bim4 = 70;
		
		System.out.println(ana.media());
		System.out.println(ana.passouDeAno());


	}

}
