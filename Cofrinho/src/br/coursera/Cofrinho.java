package br.coursera;

public class Cofrinho {
	int moedaUmCentavo;
	int moedaCincoCentavos;
	int moedaDezCentavos;
	int moedaVinteECincoCentavos;
	int moedaCinquenta;
	int moedaUmReal;

	int quantidadeMoedas;
	
	
	void contaNumeroMoedasArmazenadas(String moeda){
		
		quantidadeMoedas++;
		
		
	}
	
	void contaNumeroMoedasDeterminadoValor(String valor) {
		
		if (valor.equals("moedaUmCentavo")) {
			
			moedaUmCentavo++;
			
		}else if(valor.equals("moedaCincoCentavos")) {
			
			moedaCincoCentavos++;
		}
        else if(valor.equals("moedaDezCentavos")) {
			
        	moedaDezCentavos++;
		}
		
       else if(valor.equals("moedaVinteECincoCentavos")) {
			
    	   moedaVinteECincoCentavos++;
		}
		
       else if(valor.equals("moedaCinquenta")) {
			
    	   moedaCinquenta++;
		}
		
       else if(valor.equals("moedaUmReal")) {
			
    	   moedaUmReal++;
		}
		
	}
	
	void informaMoedaMaiorValor() {
		
		
		
		
	}

}
