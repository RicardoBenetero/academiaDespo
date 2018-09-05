package br.coursera;

public class Pizza {
	
	String sabor;
	double preco = 20.0;
	
	public Pizza(String sabor) {
		
		this.sabor = sabor;
		
		
	}
	
	public double calculaPreco(){
		
		if(sabor == "C") {
			preco = 25.0;
		}else if (sabor == "M") {
			preco = 22.0;
		}else if (sabor == "P")
			preco = 30.0;
		
		return preco;
		
		
		
	}
		
	

}
