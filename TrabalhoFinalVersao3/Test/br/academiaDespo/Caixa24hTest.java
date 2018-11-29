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
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		double delta = 1.0;
		
		assertEquals(0.00, atm.consultarSaldo(),delta);
		
		
		
	}
	
	@Test
	public void deveraRetornarSaldoConformeSomadeValoresDepositados() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		
		atm.realizarDeposito(250.00);
		atm.realizarDeposito(250.00);

		
		double delta = 1.0;
		
		
		
		assertEquals(500.00, atm.consultarSaldo(),delta);
		
		
		
	}
	@Test(expected = ValorInvalidoException.class)
    public void deveraRetornarExcecaoParaValorInvalidoNoDeposito() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		
		atm.realizarDeposito(-1.0);
		

}
	
	@Test
	public void deveraDiminuirSaldoConformeValorSacado() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		
		atm.realizarDeposito(250.00);
		atm.realizarDeposito(250.00);
		atm.sacar(50.00);

		
		double delta = 1.0;
		
		
		
		assertEquals(450.00, atm.consultarSaldo(),delta);
		
		
		
	}
	
	@Test(expected = SaldoInsuficienteException.class)
    public void deveraRetornarExcecaoParaSaldoInsuficienteNoSaque() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		
		atm.realizarDeposito(100.00);
		atm.sacar(100.01);
		

}
	
	@Test
	public void deveraTranferirValorDeUmAContaParaOutra() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Conta contaCorrenteBeta2 = new ContaCorrenteBeta("4567");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Banco bancoBeta2 = new BancoBeta(contaCorrenteBeta2);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		Caixa24h atm2 = new Caixa24h(bancoBeta2);

		
		atm.realizarDeposito(5000.00);
		atm.realizarTransferencia(contaCorrenteBeta, 1000.00, contaCorrenteBeta2);;


		
		double delta = 1.0;
		
		
		
		assertEquals(4000.00, atm.consultarSaldo(),delta);
		assertEquals(1000.00, atm2.consultarSaldo(),delta);

		
		
		
	}
	
	@Test
	public void deveraMostrarTransacoesEfetuadasAoConsultarExtrato() {
		
		Conta contaCorrenteBeta = new ContaCorrenteBeta("1234");
		
		Banco bancoBeta = new BancoBeta(contaCorrenteBeta);
		
		Caixa24h atm = new Caixa24h(bancoBeta);
		
		
		atm.realizarDeposito(100.00);
		atm.sacar(50.00);
		atm.consultarSaldo();
		atm.consultarExtrato();
		
		List<String> minhalista = new ArrayList<String>();
		List<String> listaRetornada = new ArrayList<String>();
		
	
		
		listaRetornada =atm.consultarExtrato();
		
		minhalista.add("operação realizada = realizar deposito: 100.0");
		minhalista.add("operação realizada = realizar saque: 50.0");
		minhalista.add("operação realizada = consulta saldo: 50.0");

		Assert.assertTrue(minhalista.size() == listaRetornada.size() && minhalista.containsAll(listaRetornada));
		
		
}
	
}
