package br.coursera;

import java.util.Random;

public class Calcula {
	
	
	
	
	public static void retornaMaiorNumero(int numero1, int numero2) {
		
		if (numero1 > numero2) {
			
			System.out.println("maior: " + numero1 );
		}else {
			
			System.out.println("maior: " + numero2 );

			
			
		}
		
		
	}
	
	public static void retornaTemperaturaConvertidaDeCelsiusParafahrenheit(int temperaturaEmGrausCelsius) {
		
		double fahrenheit = (9 * temperaturaEmGrausCelsius + 160 )/ 5;
		
		
		System.out.println("Temperatura em fahrenheit eh: " + fahrenheit);
		
	}
	
	public static void retornaNumeroAleatorio(int numero1, int numero2) {
		
		
		
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt((numero2 - numero1) + 1) + numero1;;
		System.out.println("Número gerado: " + valor);
		
		
	}
	
	
	
public static void formataCPF(String cpf) {
        
        
        String cpfFormatado = (cpf.substring(0, 3) + "." + cpf.substring(3, 6)
                + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));

        System.out.println("CPF formatado - " + cpfFormatado);

    }

}
