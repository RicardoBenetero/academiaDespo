package br.coursera;

public class Pizza {
	
	String sabor;
	double pre�o = 20.0;
	
	public Pizza(String sabor) {
		
		this.sabor = sabor;
		
		
	}
	
	public double calculaPreco(){
		
		if(sabor == "C") {
			pre�o = 25.0;
		}else if (sabor == "M") {
			pre�o = 22.0;
		}else if (sabor == "P")
			pre�o = 30.0;
		
		return pre�o;
		
		
		
	}
		
	

}
