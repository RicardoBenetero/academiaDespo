package br.gov.serpro.caixa24h;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import br.gov.serpro.banco.Conta;
import br.gov.serpro.banco.ContaCorrenteEspecial;
import br.gov.serpro.banco.BancoAlfa;
import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.caixa24h.exception.BancoInexistenteException;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class CaixaVinteQuatroHorasTest {

	BancoGeral bancoMock = Mockito.mock(BancoGeral.class);
	private int numeroConta;
	private int contaDestino;
	private Extrato extrato;

	@Before
	public void inicializa() {
		numeroConta = 123456;
		contaDestino = 12345678;
	}
    @Ignore
	@Test
	public void deveRetornarUmaConsultaDoExtrato() throws ContaInexistenteException, BancoInexistenteException {
		//dado
		extrato = new Extrato("10/11/2014", 10000, 50000);
		List<Extrato> listaExtratos = new ArrayList<Extrato>();
		listaExtratos.add(extrato);
		Mockito.when(bancoMock.consultarExtrato(numeroConta)).thenReturn(listaExtratos);
		
		//quando
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		List<Extrato> consultaExtrato = caixa24horas.consultaExtrato(123456);

		//entao
		assertEquals(listaExtratos.get(0).getData(), consultaExtrato.get(0).getData());
		assertEquals(listaExtratos.get(0).getCredito(), consultaExtrato.get(0).getCredito());
		assertEquals(listaExtratos.get(0).getDebito(), consultaExtrato.get(0).getDebito());
		assertEquals(listaExtratos.size(), consultaExtrato.size());
	}
    @Ignore
	@Test(expected = ContaInexistenteException.class)
	public void naoDevePermitirNumeroContaInexistenteParaConsultaExtrato()
			throws ContaInexistenteException, BancoInexistenteException {

		List<String> extrato = new ArrayList<String>();
		extrato.add("data: 10/11/2014 ; credito: 10000");
		Mockito.when(bancoMock.consultarExtrato(numeroConta))
				.thenThrow(new ContaInexistenteException("Conta inexistente"));
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		caixa24horas.consultaExtrato(123456);

	}
    @Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException {
		BigDecimal valorTransferido = new BigDecimal(10000);
		Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).efetuarTransferencia(numeroConta,
				contaDestino, valorTransferido);
		bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);

	}
    @Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaque()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException {
		BigDecimal valorSaque = new BigDecimal(10000);
		Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).efetuarSaque(numeroConta, valorSaque);
		bancoMock.efetuarSaque(numeroConta, valorSaque);

	}
    @Ignore
	@Test(expected = BancoInexistenteException.class)
	public void deveRetornarExcecaoQuandoInformadoBancoNulo()
			throws ContaInexistenteException, BancoInexistenteException {
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(null);
		caixa24horas.consultaExtrato(123456);

	}

	@Test
	public void deveRetornarSaldoAoInformarNumeroDaConta() throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException {
		
		/*
		BigDecimal saldoRetornado = new BigDecimal(10000);
		Mockito.when(bancoMock.consultarSaldo(numeroConta)).thenReturn(saldoRetornado);
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		BigDecimal consultaSaldo = caixa24horas.consultaSaldo(numeroConta);
		assertEquals(saldoRetornado, consultaSaldo);
		*/
		
		 BigDecimal valorInicial = new BigDecimal(10000.0);
		 
		 List<Conta> contas = new ArrayList<Conta>();
		 
		 Conta contaCorrenteTeste = new ContaCorrenteEspecial(7777,valorInicial); 
		 
		 Conta contaCorrenteTeste2 = new ContaCorrenteEspecial(101010,valorInicial);
		 
		 contas.add(contaCorrenteTeste);
		 
		 contas.add(contaCorrenteTeste2);
		 BancoGeral bancoAlfa = new BancoAlfa(contas);
		 
		 CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);
         BigDecimal valorSaqueConta7777 = new BigDecimal(500.0);
         
		 BigDecimal valorSaqueConta101010 = new BigDecimal(700.0);
		 
		 caixa24horas.efetuarSaque(7777, valorSaqueConta7777);
		 
		 caixa24horas.efetuarSaque(101010, valorSaqueConta101010);
		 
		 BigDecimal valorEsperadoConta7777 = new BigDecimal(9500.0);
		 
		 BigDecimal valorEsperadoConta101010 = new BigDecimal(9300.0);
		 
		 assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));
		
		 assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));	
	
	}
	
	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucesso()
			throws SaldoInsuficienteException, ContaInexistenteException, BancoInexistenteException {
		
		/*
		BigDecimal saldoAntesTransferencia = new BigDecimal(10000);
		doNothing().when(bancoMock).efetuarTransferencia(numeroConta, contaDestino, saldoAntesTransferencia);
		bancoMock.efetuarTransferencia(numeroConta, contaDestino, saldoAntesTransferencia);
		*/
		BigDecimal valorInicial = new BigDecimal(10000.0);
		
		BigDecimal valorTransferencia = new BigDecimal(6000.0);
		
		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteEspecial(2323,valorInicial);
		
		Conta contaCorrenteTeste2 = new ContaCorrenteEspecial(7878,valorInicial);
		
		contas.add(contaCorrenteTeste);
		
		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoAlfa);
		
		atm.efetuarTransferencia(2323, 7878, valorTransferencia);
		
		BigDecimal valorEsperadoConta2323 = new BigDecimal(4000.0);
		
		BigDecimal valorEsperadoConta7878 = new BigDecimal(16000.0);

		assertEquals(valorEsperadoConta2323, atm.consultaSaldo(2323));
		
		assertEquals(valorEsperadoConta7878, atm.consultaSaldo(7878));


	}
	@Ignore
	@Test
	public void deveRetornarSeDepositoEfetuadoComSucesso() {
		BigDecimal valorDepositado = new BigDecimal(10000);
		doNothing().when(bancoMock).efetuarDeposito(numeroConta, valorDepositado);
		bancoMock.efetuarDeposito(numeroConta, valorDepositado);
	}
	
	@Test
	public void deveRetornarSeSaqueEfetuadoComSucesso() throws SaldoInsuficienteException, ContaInexistenteException, BancoInexistenteException {
		
		/*
		BigDecimal valorSaque = new BigDecimal(10000);
		doNothing().when(bancoMock).efetuarSaque(numeroConta, valorSaque);
		bancoMock.efetuarDeposito(numeroConta, valorSaque);
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
         
		*/
		
		 BigDecimal valorInicial = new BigDecimal(10000.0);

		 List<Conta> contas = new ArrayList<Conta>();

		 Conta contaCorrenteTeste = new ContaCorrenteEspecial(7777,valorInicial);
		
		 Conta contaCorrenteTeste2 = new ContaCorrenteEspecial(101010,valorInicial);

		 contas.add(contaCorrenteTeste);
		 
		 contas.add(contaCorrenteTeste2);

		 BancoGeral bancoAlfa = new BancoAlfa(contas);

		 CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);		
		
         BigDecimal valorSaqueConta7777 = new BigDecimal(500.0);
		
		 BigDecimal valorSaqueConta101010 = new BigDecimal(700.0);
		 
         caixa24horas.efetuarSaque(7777, valorSaqueConta7777);
		
		 caixa24horas.efetuarSaque(101010, valorSaqueConta101010);

         BigDecimal valorEsperadoConta7777 = new BigDecimal(9500.0);
		
		 BigDecimal valorEsperadoConta101010 = new BigDecimal(9300.0);

		 assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));
		
		 assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));
		 
	
	}

}
