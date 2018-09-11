package br.coursera;

public class Calcula {

	public static int retornaMaiorNumero(int numero1, int numero2) {
		return 0;

	}

	public static int retornaTemperaturaConvertida(int temperaturaEmGrausCelsius) {
		return 0;

	}

	public static int retornaNumeroAleatorio(int numero1, int numero2) {
		return 0;

	}

	public static boolean validaCPF(String cpf) {

		return true;

	}

	public static void formataCPF(String cpf) {
		
		
		String cpfFormatado = (cpf.substring(0, 3) + "." + cpf.substring(3, 6)
				+ "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));

		System.out.println(cpfFormatado);

	}

}
