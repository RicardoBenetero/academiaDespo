package br.coursera;

public class Aluno {
	public int bim1;
	public int bim2;
	public int bim3;
	public int bim4;

	public int media() {

		int total = 0;

		total += bim1;
		total += bim2;
		total += bim3;
		total += bim4;
		return total / 4;

	}

	public boolean passouDeAno() {

		if (media() >= 60)
			return true;
		return false;

	}

}
