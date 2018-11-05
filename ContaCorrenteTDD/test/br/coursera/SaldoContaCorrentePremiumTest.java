package br.coursera;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SaldoContaCorrentePremiumTest {

    @Test
    public void deveSerIgualA106PorcentoDaSomaDosValoresDepositados() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();
        contaCorrente.depositar(50.0);
        contaCorrente.depositar(100.0);

        // When
        double saldo = contaCorrente.obterSaldo();

        // Then
        assertEquals(159, saldo, 0);
    }

}
