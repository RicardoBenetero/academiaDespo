package br.coursera;

public class Entrega {
	
	double valorEntrega;
	String diaSemana;
	
	public double calculaValorEntrega(double distancia, String diaSemana) {
		this.diaSemana = diaSemana;
		
		if (diaSemana.equals("diaUtil") && distancia <= 5 ) {
			valorEntrega = 1.0;
		}else if (diaSemana.equals("diaUtil") && distancia > 5) {
				valorEntrega = 5.0;
		}else if (diaSemana.equals("naoDiaUtil") && distancia <= 5) {
			valorEntrega = 10.0;
			
		}else if (diaSemana.equals("naoDiaUtil") && distancia > 5) {
			valorEntrega = 15.0;
		
		}
		
		return valorEntrega;
		
		
		
	}

}
