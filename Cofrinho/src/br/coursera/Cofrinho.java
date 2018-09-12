package br.coursera;

public class Cofrinho {
	int moedaUmCentavo;
	int moedaCincoCentavos;
	int moedaDezCentavos;
	int moedaVinteECincoCentavos;
	int moedaCinquentaCentavos;
	int moedaUmReal;
	
	int quantidadeMoedas;
	
	
	
	

	
	void contaNumeroMoedasArmazenadas(String moeda){
		
		
		if(moeda .equals("moedaUmCentavo") || moeda.equals("moedaCincoCentavos") || moeda.equals("moedaDezCentavos") || moeda.equals("moedaVinteECincoCentavos") || moeda.equals("moedaCinquentaCentavos") || moeda.equals("moedaUmReal")){
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
		
		if (this.moedaUmReal != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda De Um Real");
			
		}else if(this.moedaCinquentaCentavos != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda Cinquenta Centavos");
		
		}else if(this.moedaVinteECincoCentavos != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda Vinte E Cinco Centavos");
		
		}else if(this.moedaDezCentavos != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda Dez Centavos");
		
		}else if(this.moedaCincoCentavos != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda Cinco Centavos");
		
		}else if(this.moedaUmCentavo != 0){
			System.out.println("Moeda de maior valor no cofrinho - moeda Um Centavo");
		
		}
		
		
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
