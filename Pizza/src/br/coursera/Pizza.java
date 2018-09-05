package br.coursera;

public class Pizza {
	
	String sabor;
	double preco;
	
	public Pizza(String sabor) {
		
		this.sabor = sabor;
		
		
	}
	
	public double calculaPreco(){
		
		if(sabor == "Calabreza") {
			preco = 25.0;
		}else if (sabor == "Muzzarela") {
			preco = 22.0;
		}else if (sabor == "Portuguesa")
			preco = 30.0;
		
		return preco;
		
		
		
	}
		
	

}
