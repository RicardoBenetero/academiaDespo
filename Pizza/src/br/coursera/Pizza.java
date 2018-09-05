package br.coursera;

public class Pizza {
	
	String sabor;
	double preço = 20.0;
	
	public Pizza(String sabor) {
		
		this.sabor = sabor;
		
		
	}
	
	public double calculaPreco(){
		
		if(sabor == "C") {
			preço = 25.0;
		}else if (sabor == "M") {
			preço = 22.0;
		}else if (sabor == "P")
			preço = 30.0;
		
		return preço;
		
		
		
	}
		
	

}
