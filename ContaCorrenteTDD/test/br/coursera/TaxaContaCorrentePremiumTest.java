package br.coursera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxaContaCorrentePremiumTest {

    @Test
    public void deveSerBaixa() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();

        // When
        double taxaJuros = contaCorrente.calcularTaxaJuros();

        // Then
        assertEquals(1.0, taxaJuros, 0);
    }

}
