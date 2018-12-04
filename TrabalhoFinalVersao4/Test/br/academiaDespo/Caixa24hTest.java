package br.academiaDespo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.academiaDespo.Banco.Banco;
import br.academiaDespo.Banco.Conta;
import br.academiaDespo.Caixa.Caixa24h;
import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.SaldoInsuficienteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;

public class Caixa24hTest {
	
	@Test
	public void deveraRetornarSaldoZeradoQuandoNenhumDepositoFeito() throws ContaInexistenteException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");

		contas.add(contaCorrenteTeste);

		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorEsperado = new BigDecimal("0.0");
		

		assertEquals(valorEsperado, atm.consultarSaldo("1234"));

	}
	
	@Test
	public void deveraRetornarSaldoDeAcordoComValorDepositadoQuandoSaldoAnteriorIgualZero() throws ContaInexistenteException, ValorInvalidoException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");

		contas.add(contaCorrenteTeste);

		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDeposito = new BigDecimal("600.0");
		
		atm.realizarDeposito("1234", valorDeposito);
		
		BigDecimal valorEsperado = new BigDecimal("600.0");
		

		assertEquals(valorEsperado, atm.consultarSaldo("1234"));

	}
	
	@Test
	public void deveraFazerDepositoQuandoTemMaisDeUmaConta() throws ContaInexistenteException, ValorInvalidoException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");
		
		Conta contaCorrenteTeste2 = new ContaCorrenteTeste("9999");


		contas.add(contaCorrenteTeste);
		contas.add(contaCorrenteTeste2);


		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDepositoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorDepositoConta9999 = new BigDecimal("800.0");

		
		atm.realizarDeposito("1234", valorDepositoConta1234);
		
		atm.realizarDeposito("9999", valorDepositoConta9999);

		
		BigDecimal valorEsperadoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorEsperadoConta9999 = new BigDecimal("800.0");

		

		assertEquals(valorEsperadoConta1234, atm.consultarSaldo("1234"));
		
		assertEquals(valorEsperadoConta9999, atm.consultarSaldo("9999"));


	}
	@Test(expected = ContaInexistenteException.class)

	public void deveraRetornarExcecaoParaContaInexistenteNoDeposito() throws ContaInexistenteException, ValorInvalidoException {



		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");
		
		Conta contaCorrenteTeste2 = new ContaCorrenteTeste("9999");


		contas.add(contaCorrenteTeste);
		contas.add(contaCorrenteTeste2);


		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDepositoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorDepositoConta9999 = new BigDecimal("800.0");

		
		atm.realizarDeposito("1234", valorDepositoConta1234);
		
		atm.realizarDeposito("9999", valorDepositoConta9999);

		
		BigDecimal valorEsperadoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorEsperadoConta9999 = new BigDecimal("800.0");

		

		assertEquals(valorEsperadoConta1234, atm.consultarSaldo("1234"));
		
		assertEquals(valorEsperadoConta9999, atm.consultarSaldo("5555"));



	}
	
	@Test(expected = ValorInvalidoException.class)

	public void deveraRetornarExcecaoParaValorInvalidoNoDeposito() throws ContaInexistenteException, ValorInvalidoException {



		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");
		
		Conta contaCorrenteTeste2 = new ContaCorrenteTeste("9999");


		contas.add(contaCorrenteTeste);
		contas.add(contaCorrenteTeste2);


		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDepositoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorDepositoConta9999 = new BigDecimal("-1.0");

		
		atm.realizarDeposito("1234", valorDepositoConta1234);
		
		atm.realizarDeposito("9999", valorDepositoConta9999);

		
		BigDecimal valorEsperadoConta1234 = new BigDecimal("700.0");
		
		BigDecimal valorEsperadoConta9999 = new BigDecimal("800.0");

		

		assertEquals(valorEsperadoConta1234, atm.consultarSaldo("1234"));
		
		assertEquals(valorEsperadoConta9999, atm.consultarSaldo("9999"));



	}
	
	@Test
	public void deveraDiminuirSaldoConformeValorSaque() throws ContaInexistenteException, ValorInvalidoException, SaldoInsuficienteException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("7777");
		
		Conta contaCorrenteTeste2 = new ContaCorrenteTeste("101010");


		contas.add(contaCorrenteTeste);
		contas.add(contaCorrenteTeste2);


		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDepositoConta7777 = new BigDecimal("700.0");
		
		BigDecimal valorDepositoConta101010 = new BigDecimal("800.0");
		
		
        BigDecimal valorSaqueConta7777 = new BigDecimal("500.0");
		
		BigDecimal valorSaqueConta101010 = new BigDecimal("700.0");

		
		atm.realizarDeposito("7777", valorDepositoConta7777);
		
		atm.realizarDeposito("101010", valorDepositoConta101010);
		
		atm.sacar("7777", valorSaqueConta7777);
		
		atm.sacar("101010", valorSaqueConta101010);


		
		BigDecimal valorEsperadoConta7777 = new BigDecimal("200.0");
		
		BigDecimal valorEsperadoConta101010 = new BigDecimal("100.0");

		

		assertEquals(valorEsperadoConta7777, atm.consultarSaldo("7777"));
		
		assertEquals(valorEsperadoConta101010, atm.consultarSaldo("101010"));


	}
	
	@Test
	public void deveraTransferirDeUmaContaParaOutra() throws ContaInexistenteException, ValorInvalidoException, SaldoInsuficienteException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("2323");
		
		Conta contaCorrenteTeste2 = new ContaCorrenteTeste("7878");


		contas.add(contaCorrenteTeste);
		contas.add(contaCorrenteTeste2);


		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorDepositoConta2323 = new BigDecimal("700.0");
		
		BigDecimal valorDepositoConta7878 = new BigDecimal("800.0");
		
		
        BigDecimal valorTransferenciaConta2323 = new BigDecimal("500.0");
		

		
		atm.realizarDeposito("2323", valorDepositoConta2323);
		
		atm.realizarDeposito("7878", valorDepositoConta7878);
		
		atm.realizarTransferencia("2323", valorTransferenciaConta2323,"7878");
		


		
		BigDecimal valorEsperadoConta2323 = new BigDecimal("200.0");
		
		BigDecimal valorEsperadoConta7878 = new BigDecimal("1300.0");

		

		assertEquals(valorEsperadoConta2323, atm.consultarSaldo("2323"));
		
		assertEquals(valorEsperadoConta7878, atm.consultarSaldo("7878"));


	}

}
