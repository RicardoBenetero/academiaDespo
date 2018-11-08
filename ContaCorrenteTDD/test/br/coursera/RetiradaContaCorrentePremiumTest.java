package br.coursera;



import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RetiradaContaCorrentePremiumTest {

    private static double LIMITE_SALDO_PREMIUM = 50.00;

    @Test
    public void devePermitirComValorMenorQueSaldoTotal() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();
        double valorDeposito = 100;
        double valorRetirada = 60;
        contaCorrente.depositar(valorDeposito);

        // When
        double valorSaldo = contaCorrente.obterSaldo();
        try {
            contaCorrente.efetuarRetirada(valorRetirada);
        } catch (SaldoInsuficienteException exception) {
            fail("Deveria permitir efetuar retirada com valor menor que saldo total");
        }

        // Then
        double valorEsperado = valorSaldo - valorRetirada;
        assertEquals(valorEsperado, contaCorrente.obterSaldo(), 0);
    }

    @Test
    public void devePermitirComValorIgualAoSaldoTotal() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();
        double valorDeposito = 100;
        contaCorrente.depositar(valorDeposito);

        // When
        double valorSaldo = contaCorrente.obterSaldo();
        try {
            contaCorrente.efetuarRetirada(valorSaldo);
        } catch (SaldoInsuficienteException exception) {
            fail("Deveria permitir efetuar retirada com valor igual que saldo total");
        }

        // Then
        assertEquals(0.0, contaCorrente.obterSaldo(), 0);
    }


    @Test
    public void devePermitirComSaldoNegativoAteLimiteEspecialPremium() {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();
        double valorDeposito = 100;
        contaCorrente.depositar(valorDeposito);

        // When
        double valorSaldo = contaCorrente.obterSaldo();
        try {
            contaCorrente.efetuarRetirada(valorSaldo + LIMITE_SALDO_PREMIUM);
        } catch (SaldoInsuficienteException exception) {
            fail("Deveria permitir efetuar retirada com valor igual que limite negativo especial conta premium");
        }

        // Then
        double valorSaldoEsperado = LIMITE_SALDO_PREMIUM * -1;
        assertEquals(valorSaldoEsperado, contaCorrente.obterSaldo(), 0);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void naoDevePermitirSaqueSuperiorAoLimiteNegativoEspecialPremium() throws SaldoInsuficienteException {

        // Given
        ContaCorrente contaCorrente = new ContaCorrentePremium();
        double valorDeposito = 50;
        contaCorrente.depositar(valorDeposito);

        // When
        double valorSaldo = contaCorrente.obterSaldo();
        contaCorrente.efetuarRetirada(valorSaldo + LIMITE_SALDO_PREMIUM + 0.01);

    }

}
