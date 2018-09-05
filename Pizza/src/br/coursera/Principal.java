package br.coursera;

public class Principal {

	public static void main(String[] args) {

		
		Carrinho carrinho = new Carrinho();
		
		System.out.println("O valor do seu pedido eh " + carrinho.calculaPrecoTotal("C", 6, "naoDiaUtil"));
	}

}
