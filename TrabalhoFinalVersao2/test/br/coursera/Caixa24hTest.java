package br.coursera;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Caixa24hTest {

	@Test
	public void deveraRetornarSaldo() {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);

		conta.realizarDeposito(200.00);

		Caixa24h atm = new Caixa24h(bancoBeta);

		//
		ContaCorrenteBancoBeta conta2 = new ContaCorrenteBancoBeta("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao", bancoBeta);

		conta2.realizarDeposito(400.00);

		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarDepositoComSucesso() {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);
		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito(cliente1, 200.00);

		//
		ContaCorrenteBancoBeta conta2 = new ContaCorrenteBancoBeta("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao", bancoBeta);

		atm.realizarDeposito(cliente2, 400.00);

		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarSaqueComSucesso() {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);
		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito(cliente1, 200.00);
		atm.sacar(cliente1, 100.00);

		//
		ContaCorrenteBancoBeta conta2 = new ContaCorrenteBancoBeta("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao", bancoBeta);

		atm.realizarDeposito(cliente2, 400.00);
		atm.sacar(cliente2, 100.00);

		double delta = 0.01;

		assertEquals(100.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(300.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaqueSuperiorAoValorDepositado() throws SaldoInsuficienteException {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);
		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito(cliente1, 200.00);
		atm.sacar(cliente1, 200.01);

	}

	@Test
	public void deveraRealizarTransferenciaComSucesso() {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);
		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito(cliente1, 800.00);

		//
		ContaCorrenteBancoBeta conta2 = new ContaCorrenteBancoBeta("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao", bancoBeta);

		atm.realizarDeposito(cliente2, 400.00);

		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);

		double delta = 0.01;

		atm.consultarSaldo(cliente1);

		assertEquals(700.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(500.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraConsultarExtratoComSucesso() {

		ContaCorrenteBancoBeta conta = new ContaCorrenteBancoBeta("1234");

		Banco bancoBeta = new BancoBeta(conta);

		Cliente cliente1 = new Cliente(conta, "Ana", bancoBeta);
		Caixa24h atm = new Caixa24h(bancoBeta);

		atm.realizarDeposito(cliente1, 800.00);

		//
		ContaCorrenteBancoBeta conta2 = new ContaCorrenteBancoBeta("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao", bancoBeta);

		atm.realizarDeposito(cliente2, 400.00);

		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);

		atm.consultarSaldo(cliente1);
		atm.realizarDeposito(cliente1, 800.00);
		atm.sacar(cliente1, 200.00);
		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);
		atm.consultarExtrato(cliente1);

	}

	@Test
	public void deveraRetornarSaldoQuandoBancoAlfa() {

		ContaCorrenteBancoAlfa conta = new ContaCorrenteBancoAlfa("1234");
		Cliente cliente1 = new Cliente(conta, "Ana");

		Banco bancoAlfa = new BancoAlfa(cliente1);

	

		

		Caixa24h atm = new Caixa24h(bancoAlfa);
		
		atm.realizarDeposito(cliente1,200.00);

		//
		Conta conta2 = new ContaCorrenteBancoAlfa("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");

		atm.realizarDeposito(cliente2,400.00);

		double delta = 0.01;

		assertEquals(10.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(10.00, atm.consultarSaldo(cliente2), delta);

	}

}
