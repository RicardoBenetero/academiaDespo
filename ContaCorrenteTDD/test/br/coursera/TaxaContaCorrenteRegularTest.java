package br.coursera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxaContaCorrenteRegularTest {

    @Test
    public void deveSerAlta() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrenteRegular();

        // When
        double taxaJuros = contaCorrente.calcularTaxaJuros();

        // Then
        assertEquals(5.0, taxaJuros, 0);
    }

}
