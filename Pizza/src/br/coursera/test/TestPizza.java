package br.coursera.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.Carrinho;

public class TestPizza {
	
	
    
	private static final double DELTA = 1e-2;
	
	@Test
	public void testPizza() {
		Carrinho carrinhoPedido1 = new Carrinho();
		carrinhoPedido1.cliente = "Maria";
		Carrinho carrinhoPedido2 = new Carrinho();
		carrinhoPedido2.cliente = "Joao";
		Carrinho carrinhoPedido3 = new Carrinho();
		carrinhoPedido3.cliente = "Ana";
		Carrinho carrinhoPedido4 = new Carrinho();
		carrinhoPedido4.cliente = "Bia";
		
		
		
		assertEquals(26.0,carrinhoPedido1.calculaPrecoTotal("Calabreza", 5, "diaUtil"),DELTA);
		assertEquals(27.0,carrinhoPedido2.calculaPrecoTotal("Muzzarela", 6, "diaUtil"),DELTA);
		assertEquals(35.0,carrinhoPedido3.calculaPrecoTotal("Calabreza", 5, "naoDiaUtil"),DELTA);
		assertEquals(45.0,carrinhoPedido4.calculaPrecoTotal("Portuguesa", 6, "naoDiaUtil"),DELTA);

	}

}
