package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaixa24h {

	@Test
	public void deveraRetornarSaldo() {

		Banco banco = new Banco();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");

		conta.realizarDeposito(200.00);

		banco.clientes.add(cliente1);
		banco.contas.add(conta);

		Caixa24h atm = new Caixa24h(banco);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");

		conta2.realizarDeposito(400.00);

		banco.clientes.add(cliente2);
		banco.contas.add(conta2);

		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarDepositoComSucesso() {

		Banco banco = new Banco();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(banco);

		banco.clientes.add(cliente1);
		banco.contas.add(conta);

		atm.realizarDeposito(cliente1, 200.00);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");

		banco.clientes.add(cliente2);
		banco.contas.add(conta2);

		atm.realizarDeposito(cliente2, 400.00);

		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarSaqueComSucesso() {

		Banco banco = new Banco();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(banco);

		banco.clientes.add(cliente1);
		banco.contas.add(conta);

		atm.realizarDeposito(cliente1, 200.00);
		atm.Sacar(cliente1, 100.00);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");

		banco.clientes.add(cliente2);
		banco.contas.add(conta2);

		atm.realizarDeposito(cliente2, 400.00);
		atm.Sacar(cliente2, 100.00);

		double delta = 0.01;

		assertEquals(100.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(300.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaqueSuperiorAoValorDepositado() throws SaldoInsuficienteException {

		Banco banco = new Banco();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(banco);

		banco.clientes.add(cliente1);
		banco.contas.add(conta);

		atm.realizarDeposito(cliente1, 200.00);
		atm.Sacar(cliente1, 200.01);

	}
}
