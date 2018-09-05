package br.coursera;

public class Entrega {
	
	double valorEntrega;
	String diaUtil;
	String naoDiaUtil;
	
	
	public double calculaValorEntrega(double distancia, String diaSemana) {
		
		
		if (diaSemana == diaUtil && distancia <= 5 ) {
			valorEntrega = 1.0;
		}else if (diaSemana == diaUtil && distancia >= 5) {
				valorEntrega = 5.0;
		}else if (diaSemana == naoDiaUtil && distancia <= 5) {
			valorEntrega = 10.0;
			
		}else if (diaSemana == naoDiaUtil && distancia >= 5) {
			valorEntrega = 15.0;
		
		}
		
		return valorEntrega;
		
		
		
	}

}
