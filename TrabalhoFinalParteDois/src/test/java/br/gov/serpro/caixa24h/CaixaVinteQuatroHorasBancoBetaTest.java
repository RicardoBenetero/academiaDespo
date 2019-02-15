package br.gov.serpro.caixa24h;

import static org.junit.Assert.*;

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
		
		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10151);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(10152);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		caixa24horas.consultaSaldo(10151);
		
		caixa24horas.consultaSaldo(10152);

		LocalDate dataHoje = LocalDate.now();
		
		BigDecimal valor1 = new BigDecimal(0.5); 

		BigDecimal valor2 = new BigDecimal(0.5); 
		
		assertEquals("Saque", caixa24horas.consultaExtrato(10151).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(10151).iterator().next().getData());
		assertEquals(valor1, caixa24horas.consultaExtrato(10151).iterator().next().getDebito());

		assertEquals("Saque", caixa24horas.consultaExtrato(10152).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(10152).iterator().next().getData());
		assertEquals(valor2, caixa24horas.consultaExtrato(10152).iterator().next().getDebito());

	}
	
	
	
	@Test(expected = ContaInexistenteException.class)
	public void naoDevePermitirNumeroContaInexistenteParaConsultaExtrato()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
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

		caixa24horas.efetuarTransferencia(7777, 101010, valorTransferencia);

	}

	
	 
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		BigDecimal valorSaqueConta = new BigDecimal(20000.1);

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
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(null);
		caixa24horas.consultaExtrato(123456);

	}
	
	
	
	
	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		BigDecimal valorRetornado = new BigDecimal(0.0);
		
		BigDecimal valorEsperado = new BigDecimal(6000.0); //considerando limite
		
		valorRetornado = caixa24horas.consultaSaldo(3333);
		
		assertTrue(valorEsperado.doubleValue() == valorRetornado.doubleValue());
		


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

		BigDecimal valorEsperado1 = new BigDecimal(7000.0); // considerar limite

		BigDecimal valorEsperado2 = new BigDecimal(12985.990); // considerar limite
		
		BigDecimal valorRetornado1 = new BigDecimal(0.0);

		BigDecimal valorRetornado2 = new BigDecimal(0.0);
		
		valorRetornado1 = caixa24horas.consultaSaldo(3333);
		
		valorRetornado2 = caixa24horas.consultaSaldo(4444);
		
		assertTrue(valorEsperado1.doubleValue() == valorRetornado1.doubleValue());

		assertTrue(valorEsperado2.doubleValue() == valorRetornado2.doubleValue());



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

		BigDecimal valorEsperado1 = new BigDecimal(5100.0); //considerando o limite

		BigDecimal valorEsperado2 = new BigDecimal(5700.0); //considerando o limite
		
		BigDecimal valorRetornado1 = new BigDecimal(0.0);
		
		BigDecimal valorRetornado2 = new BigDecimal(0.0);

		valorRetornado1 = caixa24horas.consultaSaldo(6666);
		
		valorRetornado2 = caixa24horas.consultaSaldo(9999);
		
		assertTrue(valorEsperado1.doubleValue() == valorRetornado1.doubleValue());

		assertTrue(valorEsperado2.doubleValue() == valorRetornado2.doubleValue());

		
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

		
		BigDecimal valorEsperadoConta3333 = new BigDecimal(5496.5); //considerando o limite

		
		caixa24horas.efetuarSaque(3333, valorSaque3333);


		assertEquals(valorEsperadoConta3333, caixa24horas.consultaSaldo(3333));


	}

	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10012);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10014);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		
		BigDecimal  valorSaque = new BigDecimal(100.0);
		
		BigDecimal  valorDeposito = new BigDecimal(5000.0);
		
		BigDecimal  valorTransferencia = new BigDecimal(1000.0);

		caixa24horas.efetuarDeposito(10014, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia);
				
		caixa24horas.efetuarSaque(10012, valorSaque);

		BigDecimal valorEsperado = new BigDecimal(898.5); // considerar taxa de saque

		assertEquals(valorEsperado, caixa24horas.consultaSaldo(10012));


	}
	@Test(expected = SaldoInsuficienteException.class)
	public void deveRetornarExcecaoQuandoSaldoAbaixoDoLimiteDeCincoMilNegativoAoEfetuarSaqueEmContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		

		BigDecimal valorDeposito = new BigDecimal(50000.0);
		
		BigDecimal valorTransferencia = new BigDecimal(10000.0);


		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(10003);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10004);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BigDecimal valorSaqueConta2 = new BigDecimal(19900.0);
		
		caixa24horas.efetuarDeposito(10003, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10003, 10004, valorTransferencia);

		caixa24horas.efetuarSaque(10004, valorSaqueConta2);

		BigDecimal valorEsperadoConta1 = new BigDecimal(-5000.0);

		assertEquals(valorEsperadoConta1, caixa24horas.consultaSaldo(10004));

	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void deveRetornarExcecaoQuandoSaldoAbaixoDoLimiteDeDuzentosNegativoAoEfetuarSaqueEmContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		

		BigDecimal valorDeposito = new BigDecimal(50000.0);
		
		BigDecimal valorTransferencia = new BigDecimal(1000.0);


		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10030);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(10031);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BigDecimal valorSaqueConta2 = new BigDecimal(2400.0);
		
		caixa24horas.efetuarDeposito(10030, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10030, 10031, valorTransferencia);

		caixa24horas.efetuarSaque(10031, valorSaqueConta2);

		BigDecimal valorEsperadoConta1 = new BigDecimal(-200.0);

		assertEquals(valorEsperadoConta1, caixa24horas.consultaSaldo(10031));

	}
	
	
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeDuasOperacoesDiaContaComum_ConsultaSaldo()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {


		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10010);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(10011);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		caixa24horas.consultaSaldo(10010);
		caixa24horas.consultaSaldo(10010);
		caixa24horas.consultaSaldo(10010);


	}
	
	@Test
	public void devePermitirRealizarMaisDeDuasOperacoesDiaContaEspecial_ConsultaSaldo()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {


		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(10010);

		contas.add(contaCorrenteTeste);

		caixa24horas.consultaSaldo(10010);
		caixa24horas.consultaSaldo(10010);
		caixa24horas.consultaSaldo(10010);


	}
	
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeDuasOperacoesDiaContaComum_EfetuarSaque() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10012);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10014);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		
		BigDecimal  valorSaque = new BigDecimal(100.0);
		
		BigDecimal  valorDeposito = new BigDecimal(5000.0);
		
		BigDecimal  valorTransferencia = new BigDecimal(1000.0);

		caixa24horas.efetuarDeposito(10014, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia);
				
		caixa24horas.efetuarSaque(10012, valorSaque);
		
		caixa24horas.efetuarSaque(10012, valorSaque);
		
		caixa24horas.efetuarSaque(10012, valorSaque);
		

		
	}
	
	@Test
	public void devePermitirRealizarMaisDeDuasOperacoesDiaContaEspecial_EfetuarSaque() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10012);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10014);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		
		BigDecimal  valorSaque = new BigDecimal(100.0);
		
		BigDecimal  valorDeposito = new BigDecimal(5000.0);
		
		BigDecimal  valorTransferencia = new BigDecimal(1000.0);

		caixa24horas.efetuarDeposito(10012, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10012, 10014, valorTransferencia);
				
		caixa24horas.efetuarSaque(10014, valorSaque);
		
		caixa24horas.efetuarSaque(10014, valorSaque);
		
		caixa24horas.efetuarSaque(10014, valorSaque);
		
	}
	
	
	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeDuasOperacoesDiaContaComum_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10012);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10014);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
				
		BigDecimal  valorDeposito = new BigDecimal(50000.0);
		
		BigDecimal  valorTransferencia1 = new BigDecimal(2000.0);
		
		BigDecimal  valorTransferencia2 = new BigDecimal(100.0);

		caixa24horas.efetuarDeposito(10014, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia1);
		
		caixa24horas.efetuarTransferencia(10012, 10014, valorTransferencia2);
		
		caixa24horas.efetuarTransferencia(10012, 10014, valorTransferencia2);

		caixa24horas.efetuarTransferencia(10012, 10014, valorTransferencia2);
	
	}

    @Test
	public void devePermitirRealizarMaisDeDuasOperacoesDiaContaEspecial_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

    	ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(10012);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(10014);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
				
		BigDecimal  valorDeposito = new BigDecimal(50000.0);
		
		BigDecimal  valorTransferencia1 = new BigDecimal(2000.0);
		
		BigDecimal  valorTransferencia2 = new BigDecimal(100.0);

		caixa24horas.efetuarDeposito(10014, valorDeposito);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia1);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia2);
		
		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia2);

		caixa24horas.efetuarTransferencia(10014, 10012, valorTransferencia2);
	
	}

}
