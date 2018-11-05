package  br.coursera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaldoContaCorrenteRegularTest {

    @Test
    public void deveSerIgualASomaDosValoresDepositados() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrenteRegular();
        contaCorrente.depositar(50.0);
        contaCorrente.depositar(100.0);

        // When
        double saldo = contaCorrente.obterSaldo();

        // Then
        assertEquals(150.0, saldo, 0);
    }

}
