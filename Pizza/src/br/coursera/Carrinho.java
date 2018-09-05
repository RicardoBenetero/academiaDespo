package br.coursera;

public class Carrinho {
	
	double precoTotal;
	String cliente;
	Pizza pizza;
	Entrega entrega;
	
	public double calculaPrecoTotal(String sabor, double distancia , String diaSemana) {
		
		Pizza pizza = new Pizza (sabor);
		Entrega entrega = new Entrega ();
		
		
		precoTotal =	pizza.calculaPreco() + entrega.calculaValorEntrega(distancia, diaSemana);
		
		return precoTotal;
		
		
	}

}
