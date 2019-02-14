package br.gov.serpro.caixa24h;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.bancoBeta.BancoBeta;
import br.gov.serpro.bancoBeta.ContaBancoBeta;
import br.gov.serpro.bancoBeta.ContaCorrenteComumBancoBeta;
import br.gov.serpro.bancoBeta.ContaCorrenteEspecialBancoBeta;
import br.gov.serpro.caixa24h.exception.BancoInexistenteException;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class CaixaVinteQuatroHorasBancoBetaTest {
	private List<ContaBancoBeta> contas;
	

	private ContaBancoBeta contaCorrenteComum1;

	private ContaBancoBeta contaCorrenteComum2;
	
	private ContaBancoBeta contaCorrenteEspecial1;

	private ContaBancoBeta contaCorrenteEspecial2;
	
	private BancoGeral bancoBeta;

	private CaixaVinteQuatroHoras caixa24horas;
	
	private BigDecimal  valorTransferencia;

	private BigDecimal valorDeposito ;
	

	@Before
	public void preparaMassa() throws BancoInexistenteException, ContaInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		this.contas = new ArrayList<ContaBancoBeta>();

		this.contaCorrenteComum1 = new ContaCorrenteComumBancoBeta(7777);

		this.contaCorrenteComum2 = new ContaCorrenteComumBancoBeta(101010);
		
		this.contaCorrenteEspecial1 = new ContaCorrenteEspecialBancoBeta(3333);

		this.contaCorrenteEspecial2 = new ContaCorrenteEspecialBancoBeta(4444);
		
		contas.add(contaCorrenteComum1);

		contas.add(contaCorrenteComum2);
		
		contas.add(contaCorrenteEspecial1);

		contas.add(contaCorrenteEspecial2);
		
		this.bancoBeta = new BancoBeta(contas);

		this.caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);
		
		this.valorTransferencia = new BigDecimal(1000.0);

		this.valorDeposito = new BigDecimal(10000.0);		
		
		caixa24horas.efetuarDeposito(101010, valorDeposito);
		
		caixa24horas.efetuarTransferencia(101010, 7777, valorTransferencia);

        caixa24horas.efetuarDeposito(4444, valorDeposito);
		
		caixa24horas.efetuarTransferencia(4444, 3333, valorTransferencia);
		
	}

	
	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		
		BigDecimal valor1 = new BigDecimal(1000.0);
		
		BigDecimal valor2 = new BigDecimal(10000.0);
		
        caixa24horas.efetuarDeposito(3333, valor1);
		
		caixa24horas.efetuarDeposito(4444, valor1);

		LocalDate dataHoje = LocalDate.now();

		assertEquals("Deposito", caixa24horas.consultaExtrato(3333).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(3333).iterator().next().getData());
		assertEquals(valor1, caixa24horas.consultaExtrato(3333).iterator().next().getDebito());
		
		
		assertEquals("Deposito", caixa24horas.consultaExtrato(4444).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(4444).iterator().next().getData());
		assertEquals(valor2, caixa24horas.consultaExtrato(4444).iterator().next().getDebito());

	}
	
	

	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		
		BigDecimal valor1 = new BigDecimal(1000.0);
		BigDecimal valor2 = new BigDecimal(10000.0);
		
		caixa24horas.efetuarDeposito(7777, valor1);
		
		caixa24horas.efetuarDeposito(101010, valor1);

		LocalDate dataHoje = LocalDate.now();

		assertEquals("deposito", caixa24horas.consultaExtrato(7777).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(7777).iterator().next().getData());
		assertEquals(valor1, caixa24horas.consultaExtrato(7777).iterator().next().getDebito());

		assertEquals("deposito", caixa24horas.consultaExtrato(101010).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(101010).iterator().next().getData());
		assertEquals(valor2, caixa24horas.consultaExtrato(101010).iterator().next().getDebito());
		


	}
	
	
	
	@Test(expected = ContaInexistenteException.class)
	public void naoDevePermitirNumeroContaInexistenteParaConsultaExtrato()
			throws ContaInexistenteException, BancoInexistenteException {
		
		assertEquals("Saque", caixa24horas.consultaExtrato(1234).iterator().next().getOperacao());

	}
	
	
	
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		
		BigDecimal valorTransferencia = new BigDecimal(11000.1);

		caixa24horas.efetuarTransferencia(7777, 101010, valorTransferencia);

	}
	
	
	
	
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		
	     BigDecimal valorTransferencia = new BigDecimal(10000.1);

		caixa24horas.efetuarTransferencia(3333, 4444, valorTransferencia);

	}

	
	 
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		BigDecimal valorSaqueConta = new BigDecimal(10000.1);

		caixa24horas.efetuarSaque(4444, valorSaqueConta);

		caixa24horas.efetuarSaque(3333, valorSaqueConta);

	}
	
	
	
	
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		BigDecimal valorSaqueConta = new BigDecimal(10000.1);

		caixa24horas.efetuarSaque(7777, valorSaqueConta);

	    caixa24horas.efetuarSaque(101010, valorSaqueConta);

	}
	
	
	
	@Test(expected = BancoInexistenteException.class)
	public void deveRetornarExcecaoQuandoInformadoBancoNulo()
			throws ContaInexistenteException, BancoInexistenteException {
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(null);
		caixa24horas.consultaExtrato(123456);

	}
	
	
	
	
	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		
		BigDecimal valorEsperado = new BigDecimal(1000.0);
		
        assertEquals(valorEsperado, caixa24horas.consultaSaldo(3333));


	}

	
	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


		BigDecimal valorEsperado = new BigDecimal(1000.0); // considerar taxa de saque

		assertEquals(valorEsperado, caixa24horas.consultaSaldo(7777));

	}

	
	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {


		caixa24horas.efetuarTransferencia(4444, 3333, valorTransferencia);

		BigDecimal valorEsperado = new BigDecimal(2000.0);

		BigDecimal valorEsperado2 = new BigDecimal(7898.0);
		
    	assertEquals(valorEsperado, caixa24horas.consultaSaldo(3333));

		//assertEquals(valorEsperado2, caixa24horas.consultaSaldo(4444));


	}
	
	
	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {


		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(2323);

	    contas.add(contaCorrenteTeste);

		caixa24horas.efetuarTransferencia(7777, 2323, valorTransferencia);

		BigDecimal valorEsperado = new BigDecimal(1000.0);

		assertEquals(valorEsperado, caixa24horas.consultaSaldo(2323));

	}

	
	@Test
	public void deveRetornarSeDepositoEfetuadoComSucesso_ContaCorrenteEspecial() throws ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(6666);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(9999);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BigDecimal valorDepositoConta1 = new BigDecimal(100.0);

		BigDecimal valorDepositoConta2 = new BigDecimal(700.0);

		caixa24horas.efetuarDeposito(6666, valorDepositoConta1);

		caixa24horas.efetuarDeposito(9999, valorDepositoConta2);

		BigDecimal valorEsperado1 = new BigDecimal(100.0);

		BigDecimal valorEsperado2 = new BigDecimal(700.0);

		assertEquals(valorEsperado1, caixa24horas.consultaSaldo(6666));

		assertEquals(valorEsperado2, caixa24horas.consultaSaldo(9999));

		
	}
	
	
	@Test
	public void deveRetornarSeDepositoEfetuadoComSucesso_ContaCorrenteComum() throws ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10001);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(10002);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BigDecimal valorDeposito1 = new BigDecimal(100.0);

		BigDecimal valorDeposito2 = new BigDecimal(700.0);

		caixa24horas.efetuarDeposito(10001, valorDeposito1);

		caixa24horas.efetuarDeposito(10002, valorDeposito2);

		BigDecimal valorEsperado1 = new BigDecimal(100.0);

		BigDecimal valorEsperado2 = new BigDecimal(700.0);

		assertEquals(valorEsperado1, caixa24horas.consultaSaldo(10001));

		assertEquals(valorEsperado2, caixa24horas.consultaSaldo(10002));

		
	}
	
	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		
		BigDecimal valorSaque3333 = new BigDecimal(500.0);

		
		BigDecimal valorEsperadoConta3333 = new BigDecimal(486.5);

		
		caixa24horas.efetuarSaque(3333, valorSaque3333);


		assertEquals(valorEsperadoConta3333, caixa24horas.consultaSaldo(3333));


	}
	
	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		
		
		BigDecimal  valorSaqueConta7777 = new BigDecimal(500.0);

		caixa24horas.efetuarSaque(7777, valorSaqueConta7777);

		BigDecimal valorEsperadoConta7777 = new BigDecimal(486.5); // considerar taxa de saque

		assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));


	}
	
	@Test
	public void devePermitirSaldoFicarNegativoAteCincoMilAoEfetuarSaqueEmContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		

		BigDecimal valorDeposito = new BigDecimal(10000.0);

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(10003);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10004);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BigDecimal valorSaqueConta2 = new BigDecimal(10000.0);
		
		caixa24horas.efetuarDeposito(10003, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10003, 10004, valorDeposito);

		caixa24horas.efetuarSaque(10004, valorSaqueConta2);

		BigDecimal valorEsperadoConta1 = new BigDecimal(-5000.0);

		assertEquals(valorEsperadoConta1, caixa24horas.consultaSaldo(10004));

	}
	@Ignore
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_ConsultaSaldo()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);

		caixa24horas.consultaSaldo(2323);
		caixa24horas.consultaSaldo(2323);
		caixa24horas.consultaSaldo(2323);
		caixa24horas.consultaSaldo(2323);

	}
	@Ignore
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_EfetuarSaque() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);

		BigDecimal valorSaqueConta456 = new BigDecimal(2000.0);

		caixa24horas.efetuarSaque(2323, valorSaqueConta456);

		caixa24horas.efetuarSaque(2323, valorSaqueConta456);

		caixa24horas.efetuarSaque(2323, valorSaqueConta456);

		caixa24horas.efetuarSaque(2323, valorSaqueConta456);

	}
	@Ignore
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */
		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(1000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoAlfa);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

	}
	@Ignore
    @Test
	public void devePermitirRealizarMaisDeTresOperacoesDiaContaEspecial_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */
		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(1000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoAlfa);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		BigDecimal valorEsperadoConta2323 = new BigDecimal(6000.0);

		BigDecimal valorEsperadoConta7878 = new BigDecimal(14000.0);

		assertEquals(valorEsperadoConta2323, atm.consultaSaldo(2323));
		assertEquals(valorEsperadoConta7878, atm.consultaSaldo(7878));

	}

}
