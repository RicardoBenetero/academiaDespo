package br.academiaDespo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.academiaDespo.ValorInvalidoException;

public class Caixa24hTest {

	@Test
	public void deveraRetornarSaldoZeradoQuandoNenhumDepositoFeito() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		double delta = 1.0;

		assertEquals(0.00, atm.consultarSaldo("1234"), delta);

	}

	@Test
	public void deveraRetornarSaldoConformeSomadeValoresDepositados() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("1234", 250.00);
		atm.realizarDeposito("1234", 250.00);

		double delta = 1.0;

		assertEquals(500.00, atm.consultarSaldo("1234"), delta);

	}

	@Test(expected = ValorInvalidoException.class)
	public void deveraRetornarExcecaoParaValorInvalidoNoDeposito() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("1234", -1.0);

	}

	@Test
	public void deveraDiminuirSaldoConformeValorSacado() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("1234", 250.00);
		atm.realizarDeposito("1234", 250.00);
		atm.sacar("1234", 50.00);

		double delta = 1.0;

		assertEquals(450.00, atm.consultarSaldo("1234"), delta);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void deveraRetornarExcecaoParaSaldoInsuficienteNoSaque() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("1234", 100.00);
		atm.sacar("1234", 100.01);

	}

	@Test
	public void deveraTranferirValorDeUmAContaParaOutra() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("9999");

		Conta contaCorrenteBeta2 = new ContaCorrenteBeta("3333");

		contas.add(contaCorrenteBeta);
		contas.add(contaCorrenteBeta2);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("9999", 6000.00);
		
		atm.realizarDeposito("3333", 6000.00);

		atm.consultarSaldo("3333");

		atm.realizarTransferencia("9999", 1000.00, "3333");

		double delta = 1.0;

		assertEquals(4000.00, atm.consultarSaldo("9999"), delta);
		assertEquals(1000.00, atm.consultarSaldo("4567"),delta);

	}

	@Test
	public void deveraMostrarTransacoesEfetuadasAoConsultarExtrato() {
		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");

		contas.add(contaCorrenteBeta);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("1234", 100.00);
		atm.sacar("1234", 50.00);
		atm.consultarSaldo("1234");
		atm.consultarExtrato();

		List<String> minhalista = new ArrayList<String>();
		List<String> listaRetornada = new ArrayList<String>();

		listaRetornada = atm.consultarExtrato();

		minhalista.add("opera��o realizada = realizar deposito: 100.0");
		minhalista.add("opera��o realizada = realizar saque: 50.0");
		minhalista.add("opera��o realizada = consulta saldo: 50.0");

		Assert.assertTrue(minhalista.size() == listaRetornada.size() && minhalista.containsAll(listaRetornada));

	}

	@Test
	public void tenhoDuasContasQuandoFacoDepositoNasDuasDeveraDepositarCorretamente() {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteBeta = new ContaCorrenteBeta("3636");

		Conta contaCorrenteBeta2 = new ContaCorrenteBeta("8989");

		contas.add(contaCorrenteBeta);
		//contas.add(contaCorrenteBeta2);

		Banco bancoBeta = new BancoBeta(contas);

		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito("3636", 6000.0);

		//atm.realizarDeposito("8989", 1000.0);

		double delta = 1.0;

		assertEquals(6000.00, atm.consultarSaldo("3636"), delta);
		//assertEquals(1000.00, atm.consultarSaldo("8989"), delta);

	}

}
