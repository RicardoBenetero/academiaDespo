package br.coursera;

import java.util.Random;

public class Calcula {
	
	
	
	
	public static int retornaMaiorNumero(int numero1, int numero2) {
		
		if (numero1 > numero2) {
			
			return numero1 ;
		}else {
			
			return numero2 ;

			
			
		}
		
		
	}
	
	public static double retornaTemperaturaConvertidaDeCelsiusParafahrenheit(int temperaturaEmGrausCelsius) {
		
		double fahrenheit = (9 * temperaturaEmGrausCelsius + 160 )/ 5;
		
		
		return  fahrenheit;
		
	}
	
	public static int retornaNumeroAleatorio(int numero1, int numero2) {
		
		
		
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt((numero2 - numero1) + 1) + numero1;;
		return valor;
		
		
	}
	
	
	
public static String formataCPF(String cpf) {
        
        
        String cpfFormatado = (cpf.substring(0, 3) + "." + cpf.substring(3, 6)
                + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));

        return cpfFormatado;

    }

}