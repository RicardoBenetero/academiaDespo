package br.coursera;

public class Principal {

	public static void main(String[] args) {

		
		Carrinho carrinhoPedido1 = new Carrinho();
		carrinhoPedido1.cliente = "Maria";
		Carrinho carrinhoPedido2 = new Carrinho();
		carrinhoPedido2.cliente = "Joao";
		Carrinho carrinhoPedido3 = new Carrinho();
		carrinhoPedido3.cliente = "Ana";
		Carrinho carrinhoPedido4 = new Carrinho();
		carrinhoPedido4.cliente = "Bia";

		
		System.out.println("Cliente " + carrinhoPedido1.cliente + " O valor do seu pedido eh " + carrinhoPedido1.calculaPrecoTotal("Calabreza", 5, "diaUtil")+ "\n");
		
		System.out.println("Cliente " + carrinhoPedido2.cliente + " O valor do seu pedido eh " + carrinhoPedido2.calculaPrecoTotal("Muzzarela", 6, "diaUtil")+ "\n");
		
		System.out.println("Cliente " + carrinhoPedido3.cliente + " O valor do seu pedido eh " + carrinhoPedido3.calculaPrecoTotal("Calabreza", 5, "naoDiaUtil")+ "\n");
		
		System.out.println("Cliente " + carrinhoPedido4.cliente + " O valor do seu pedido eh " + carrinhoPedido4.calculaPrecoTotal("Portuguesa", 6, "naoDiaUtil")+ "\n");



	}

}
