package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCompra {

	@Test
	public void compraAVista() {
		Compra compra = new Compra(500);
		assertEquals(1, compra.getNumeroParcelas());
		assertEquals(500, compra.getValorTotal());
		assertEquals(500, compra.getValorParcela());

	}
	
	@Test
	public void compraParcelada() {
		Compra compra = new Compra(4,250);
		assertEquals(4, compra.getNumeroParcelas());
		assertEquals(1000, compra.getValorTotal());
		assertEquals(250, compra.getValorParcela());

	}

}
