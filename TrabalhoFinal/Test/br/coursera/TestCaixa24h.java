package br.coursera;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCaixa24h {

	@Test
	public void deveraRetornarSaldo() {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");

		conta.realizarDeposito(200.00);

		
	

		Caixa24h atm = new Caixa24h(bancoBeta);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");

		conta2.realizarDeposito(400.00);


		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarDepositoComSucesso() {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(bancoBeta);

		

		atm.realizarDeposito(cliente1, 200.00);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");


		atm.realizarDeposito(cliente2, 400.00);

		double delta = 0.01;

		assertEquals(200.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(400.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test
	public void deveraRealizarSaqueComSucesso() {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(bancoBeta);


		atm.realizarDeposito(cliente1, 200.00);
		atm.Sacar(cliente1, 100.00);

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");


		atm.realizarDeposito(cliente2, 400.00);
		atm.Sacar(cliente2, 100.00);

		double delta = 0.01;

		assertEquals(100.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(300.00, atm.consultarSaldo(cliente2), delta);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaqueSuperiorAoValorDepositado() throws SaldoInsuficienteException {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(bancoBeta);


		atm.realizarDeposito(cliente1, 200.00);
		atm.Sacar(cliente1, 200.01);

	}
	@Test
	public void deveraRealizarTransferenciaComSucesso() {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(bancoBeta);


		atm.realizarDeposito(cliente1, 800.00);
	

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");


		atm.realizarDeposito(cliente2, 400.00);
		
		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);
		
		double delta = 0.01;
		
		atm.consultarSaldo(cliente1);
       
		assertEquals(700.00, atm.consultarSaldo(cliente1), delta);
		assertEquals(500.00, atm.consultarSaldo(cliente2), delta);

	}
	
	@Test
	public void deveraConsultarExtratoComSucesso() {

		Banco bancoBeta = new BancoBeta();

		Conta conta = new ContaCorrente("1234");

		Cliente cliente1 = new Cliente(conta, "Ana");
		Caixa24h atm = new Caixa24h(bancoBeta);


		atm.realizarDeposito(cliente1, 800.00);
	

		//
		Conta conta2 = new ContaCorrente("1235");
		Cliente cliente2 = new Cliente(conta2, "Joao");


		atm.realizarDeposito(cliente2, 400.00);
		
		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);
		
		
		atm.consultarSaldo(cliente1);
		atm.realizarDeposito(cliente1, 800.00);
		atm.Sacar(cliente1, 200.00);
		atm.realizarTransferencia(cliente1, conta, 100.00, conta2);
		atm.consultarExtrato(cliente1);
		
		double delta = 0.01;
		
	//	List<String> transacoesEfetuadas = new ArrayList<String>();
		
	//	transacoesEfetuadas.add ("operação realizada = realizar deposito: 800.0");

		
	//	for(String teste: transacoesEfetuadas) {
		
	//	assertEquals([transacoesEfetuadas], atm.consultarExtrato(cliente1));
	//	}
	}

	
}
