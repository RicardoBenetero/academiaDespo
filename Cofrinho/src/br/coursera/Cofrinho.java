package br.coursera;

public class Cofrinho {
	int moedaUmCentavo;
	int moedaCincoCentavos;
	int moedaDezCentavos;
	int moedaVinteECincoCentavos;
	int moedaCinquentaCentavos;
	int moedaUmReal;
	
	String tipoMoeda;

	int quantidadeMoedas;
	
	
	
	

	
	void contaNumeroMoedasArmazenadas(String moeda){
		
		
		if(moeda == "moedaUmCentavo" || moeda == "moedaCincoCentavos" || moeda == "moedaDezCentavos" || moeda == "moedaVinteECincoCentavos" || moeda == "moedaCinquentaCentavos" || moeda == "moedaUmReal"){
			quantidadeMoedas++;
			contaNumeroMoedasDeterminadoValor(moeda);
		}else{
			
			System.out.println( moeda + " - invalida nao foi adicionada ao cofrinho! " );
		}
			
		
	}
	
	

	

	void contaNumeroMoedasDeterminadoValor(String moeda) {
		
		if (moeda.equals("moedaUmCentavo")) {
			
			moedaUmCentavo++;
			
		}else if(moeda.equals("moedaCincoCentavos")) {
			
			moedaCincoCentavos++;
		}
        else if(moeda.equals("moedaDezCentavos")) {
			
        	moedaDezCentavos++;
		}
		
       else if(moeda.equals("moedaVinteECincoCentavos")) {
			
    	   moedaVinteECincoCentavos++;
		}
		
       else if(moeda.equals("moedaCinquentaCentavos")) {
			
    	   moedaCinquentaCentavos++;
		}
		
       else if(moeda.equals("moedaUmReal")) {
			
    	   moedaUmReal++;
		}
		
	}
	
	void informaMoedaMaiorValor() {
		
		
		
		
	}
	
	public int getQuantidadeMoedas() {
		return quantidadeMoedas;
	}





	public int getMoedaUmCentavo() {
		return moedaUmCentavo;
	}





	public int getMoedaCincoCentavos() {
		return moedaCincoCentavos;
	}





	public int getMoedaDezCentavos() {
		return moedaDezCentavos;
	}





	public int getMoedaVinteECincoCentavos() {
		return moedaVinteECincoCentavos;
	}





	public int getMoedaCinquenta() {
		return moedaCinquentaCentavos;
	}





	public int getMoedaUmReal() {
		return moedaUmReal;
	}

}
