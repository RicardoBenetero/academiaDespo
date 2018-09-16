package br.coursera;

public class Pizza {
	
	public String sabor;
	public double preco;
	
	public Pizza(String sabor) {
		
		this.sabor = sabor;
		
		
	}
	
	public double calculaPreco(){
		
		if(sabor.equals("Calabreza")) {
			preco = 25.0;
		}else if (sabor.equals("Muzzarela")) {
			preco = 22.0;
		}else if (sabor.equals("Portuguesa"))
			preco = 30.0;
		
		return preco;
		
		
		
	}
		
	

}
