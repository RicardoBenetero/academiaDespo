package br.gov.serpro.caixa24h;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	//testeok
	@Ignore
	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// dado
		/*
		 * extrato = new Extrato("10/11/2014", 10000, 50000); List<Extrato>
		 * listaExtratos = new ArrayList<Extrato>(); listaExtratos.add(extrato);
		 * Mockito.when(bancoMock.consultarExtrato(numeroConta)).thenReturn(
		 * listaExtratos);
		 */
		// quando
		// CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		// List<Extrato> consultaExtrato = caixa24horas.consultaExtrato(123456);

		// entao
		// assertEquals(listaExtratos.get(0).getData(),
		// consultaExtrato.get(0).getData());
		// assertEquals(listaExtratos.get(0).getCredito(),
		// consultaExtrato.get(0).getCredito());
		// assertEquals(listaExtratos.get(0).getDebito(),
		// consultaExtrato.get(0).getDebito());
		// assertEquals(listaExtratos.size(), consultaExtrato.size());

		//
		
		BigDecimal valorDeposito = new BigDecimal(1000.0);

		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(7777);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(101010);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);
		
		BigDecimal valorSaqueConta7777 = new BigDecimal(500.0);

		BigDecimal valorSaqueConta101010 = new BigDecimal(500.0);
		
        caixa24horas.efetuarDeposito(7777, valorDeposito);
		
		caixa24horas.efetuarDeposito(101010, valorDeposito);

		caixa24horas.efetuarSaque(7777, valorSaqueConta7777);

		caixa24horas.efetuarSaque(101010, valorSaqueConta101010);

		LocalDate dataHoje = LocalDate.now();

		assertEquals("Deposito", caixa24horas.consultaExtrato(7777).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(7777).iterator().next().getData());
		assertEquals(valorDeposito, caixa24horas.consultaExtrato(7777).iterator().next().getDebito());
		
		
		assertEquals("Deposito", caixa24horas.consultaExtrato(101010).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(101010).iterator().next().getData());
		assertEquals(valorDeposito, caixa24horas.consultaExtrato(101010).iterator().next().getDebito());

	}
	
	
	//testeok
    @Ignore
	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		
		BigDecimal valorDeposito = new BigDecimal(1000.0);


		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(234);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(567);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);
		
		BigDecimal valorSaqueConta234 = new BigDecimal(500.0);

		BigDecimal valorSaqueConta567 = new BigDecimal(500.0);
		
		caixa24horas.efetuarDeposito(234, valorDeposito);
		
		caixa24horas.efetuarDeposito(567, valorDeposito);

		caixa24horas.efetuarSaque(234, valorSaqueConta234);

		caixa24horas.efetuarSaque(567, valorSaqueConta567);

		LocalDate dataHoje = LocalDate.now();

		
		assertEquals("deposito", caixa24horas.consultaExtrato(234).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(234).iterator().next().getData());
		assertEquals(valorDeposito, caixa24horas.consultaExtrato(234).iterator().next().getDebito());

		

		assertEquals("deposito", caixa24horas.consultaExtrato(567).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(567).iterator().next().getData());
		assertEquals(valorDeposito, caixa24horas.consultaExtrato(567).iterator().next().getDebito());
		


	}
	
	
	@Ignore
	@Test(expected = ContaInexistenteException.class)
	public void naoDevePermitirNumeroContaInexistenteParaConsultaExtrato()
			throws ContaInexistenteException, BancoInexistenteException {
		/*
		 * List<String> extrato = new ArrayList<String>();
		 * extrato.add("data: 10/11/2014 ; credito: 10000");
		 * Mockito.when(bancoMock.consultarExtrato(numeroConta)) .thenThrow(new
		 * ContaInexistenteException("Conta inexistente")); CaixaVinteQuatroHoras
		 * caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		 * caixa24horas.consultaExtrato(123456);
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(234, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(567, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);

		assertEquals("Saque", caixa24horas.consultaExtrato(7777).iterator().next().getOperacao());

	}
	
	
	@Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(11000.1);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoAlfa);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

	}
	
	
	
	@Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorTransferido = new BigDecimal(10000);
		 * Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).
		 * efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * bancoMock.efetuarTransferencia(numeroConta, contaDestino, valorTransferido);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(10000.1);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(7878, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoAlfa);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

	}

	
	@Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// BigDecimal valorSaque = new BigDecimal(10000);
		// Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).efetuarSaque(numeroConta,
		// valorSaque);
		// bancoMock.efetuarSaque(numeroConta, valorSaque);

		BigDecimal valorInicial = new BigDecimal(1000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(456, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(789, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);
		BigDecimal valorSaqueConta456 = new BigDecimal(2000.1);

		BigDecimal valorSaqueConta789 = new BigDecimal(700.0);

		caixa24horas.efetuarSaque(456, valorSaqueConta456);

		caixa24horas.efetuarSaque(789, valorSaqueConta789);

	}
	
	
	
	@Ignore
	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// BigDecimal valorSaque = new BigDecimal(10000);
		// Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).efetuarSaque(numeroConta,
		// valorSaque);
		// bancoMock.efetuarSaque(numeroConta, valorSaque);

		BigDecimal valorInicial = new BigDecimal(1000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(456, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(789, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);
		BigDecimal valorSaqueConta456 = new BigDecimal(1000.1);

		BigDecimal valorSaqueConta789 = new BigDecimal(1000.1);

		caixa24horas.efetuarSaque(456, valorSaqueConta456);

		caixa24horas.efetuarSaque(789, valorSaqueConta789);

	}
	
	
	@Ignore
	@Test(expected = BancoInexistenteException.class)
	public void deveRetornarExcecaoQuandoInformadoBancoNulo()
			throws ContaInexistenteException, BancoInexistenteException {
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(null);
		caixa24horas.consultaExtrato(123456);

	}
	
	
	
	
	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal saldoRetornado = new BigDecimal(10000);
		 * Mockito.when(bancoMock.consultarSaldo(numeroConta)).thenReturn(saldoRetornado
		 * ); CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		 * BigDecimal consultaSaldo = caixa24horas.consultaSaldo(numeroConta);
		 * assertEquals(saldoRetornado, consultaSaldo);
		 */


		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(7777);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(101010);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);
		
		BigDecimal valorDepositoConta7777 = new BigDecimal(1000.0);

		BigDecimal valorDepositoConta101010 = new BigDecimal(1000.0);
		
		BigDecimal valorSaque7777 = new BigDecimal(500.0);

		BigDecimal valorSaque101010 = new BigDecimal(700.0);
		
		BigDecimal valorEsperadoConta7777 = new BigDecimal(486.5);

		BigDecimal valorEsperadoConta101010 = new BigDecimal(274.5);
		
        caixa24horas.efetuarDeposito(7777, valorDepositoConta7777);
		
		caixa24horas.efetuarDeposito(101010, valorDepositoConta101010);

		caixa24horas.efetuarSaque(7777, valorSaque7777);

		caixa24horas.efetuarSaque(101010, valorSaque101010);

		assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));

		assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));

	}

	
	//teste ok
	@Ignore
	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal saldoRetornado = new BigDecimal(10000);
		 * Mockito.when(bancoMock.consultarSaldo(numeroConta)).thenReturn(saldoRetornado
		 * ); CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		 * BigDecimal consultaSaldo = caixa24horas.consultaSaldo(numeroConta);
		 * assertEquals(saldoRetornado, consultaSaldo);
		 */

		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(7777);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(101010);
		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);
		
		BigDecimal  valorDepositoConta7777 = new BigDecimal(1000.0);

		BigDecimal valorDepositoConta101010 = new BigDecimal(1000.0);
		
		BigDecimal  valorSaqueConta7777 = new BigDecimal(500.0);

		BigDecimal valorSaqueConta101010 = new BigDecimal(300.0);
		
		caixa24horas.efetuarDeposito(7777, valorDepositoConta7777);
		
		caixa24horas.efetuarDeposito(101010, valorDepositoConta101010);

		caixa24horas.efetuarSaque(7777, valorSaqueConta7777);

		caixa24horas.efetuarSaque(101010, valorSaqueConta101010);

		BigDecimal valorEsperadoConta7777 = new BigDecimal(486.5); // considerar taxa de saque

		BigDecimal valorEsperadoConta101010 = new BigDecimal(694.5);// considerar taxa de saque

		assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));

	    assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));

	}

	
	
	//testeok
	@Ignore
	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal saldoAntesTransferencia = new BigDecimal(10000);
		 * doNothing().when(bancoMock).efetuarTransferencia(numeroConta, contaDestino,
		 * saldoAntesTransferencia); bancoMock.efetuarTransferencia(numeroConta,
		 * contaDestino, saldoAntesTransferencia);
		 */
		BigDecimal valordeposito = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(6000.0);

		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(2323);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(7878);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoBeta);
		
		atm.efetuarDeposito(2323, valordeposito);
		
		atm.efetuarDeposito(7878, valordeposito);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		BigDecimal valorEsperadoConta2323 = new BigDecimal(3999.0);//taxa de transferencia 1 real

		BigDecimal valorEsperadoConta7878 = new BigDecimal(16000.0);

		assertEquals(valorEsperadoConta2323, atm.consultaSaldo(2323));

		assertEquals(valorEsperadoConta7878, atm.consultaSaldo(7878));

	}
	
	
	
	//testeok
	@Ignore
	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal saldoAntesTransferencia = new BigDecimal(10000);
		 * doNothing().when(bancoMock).efetuarTransferencia(numeroConta, contaDestino,
		 * saldoAntesTransferencia); bancoMock.efetuarTransferencia(numeroConta,
		 * contaDestino, saldoAntesTransferencia);
		 */
		BigDecimal valordeposito = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(6000.0);

		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(2323);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(7878);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras atm = new CaixaVinteQuatroHoras(bancoBeta);
		
		atm.efetuarDeposito(2323, valordeposito);
		
		atm.efetuarDeposito(7878, valordeposito);

		atm.efetuarTransferencia(2323, 7878, valorTransferencia);

		BigDecimal valorEsperadoConta2323 = new BigDecimal(3999.0);//taxa de transferencia 1 real

		BigDecimal valorEsperadoConta7878 = new BigDecimal(16000.0);

		assertEquals(valorEsperadoConta2323, atm.consultaSaldo(2323));

		assertEquals(valorEsperadoConta7878, atm.consultaSaldo(7878));

	}

	//testeok
	@Ignore
	@Test
	public void deveRetornarSeDepositoEfetuadoComSucesso_ContaCorrenteEspecial() throws ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteEspecialBancoBeta(7777);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteEspecialBancoBeta(101010);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);

		BigDecimal valorDepositoConta7777 = new BigDecimal(100.0);

		BigDecimal valorDepositoConta101010 = new BigDecimal(700.0);

		caixa24horas.efetuarDeposito(7777, valorDepositoConta7777);

		caixa24horas.efetuarDeposito(101010, valorDepositoConta101010);

		BigDecimal valorEsperadoConta7777 = new BigDecimal(100.0);

		BigDecimal valorEsperadoConta101010 = new BigDecimal(700.0);

		assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));

		assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));

		
	}
	
	//testeok
	@Ignore
	@Test
	public void deveRetornarSeDepositoEfetuadoComSucesso_ContaCorrenteComum() throws ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {
		
		List<ContaBancoBeta> contas = new ArrayList<ContaBancoBeta>();

		ContaBancoBeta contaCorrenteTeste = new ContaCorrenteComumBancoBeta(7777);

		ContaBancoBeta contaCorrenteTeste2 = new ContaCorrenteComumBancoBeta(101010);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);

		BancoGeral bancoBeta = new BancoBeta(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoBeta);

		BigDecimal valorDepositoConta7777 = new BigDecimal(100.0);

		BigDecimal valorDepositoConta101010 = new BigDecimal(700.0);

		caixa24horas.efetuarDeposito(7777, valorDepositoConta7777);

		caixa24horas.efetuarDeposito(101010, valorDepositoConta101010);

		BigDecimal valorEsperadoConta7777 = new BigDecimal(100.0);

		BigDecimal valorEsperadoConta101010 = new BigDecimal(700.0);

		assertEquals(valorEsperadoConta7777, caixa24horas.consultaSaldo(7777));

		assertEquals(valorEsperadoConta101010, caixa24horas.consultaSaldo(101010));

		
	}
	
	
	
	@Ignore
	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorSaque = new BigDecimal(10000);
		 * doNothing().when(bancoMock).efetuarSaque(numeroConta, valorSaque);
		 * bancoMock.efetuarDeposito(numeroConta, valorSaque); CaixaVinteQuatroHoras
		 * caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(7777, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(101010, valorInicial);

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
	@Ignore
	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		/*
		 * BigDecimal valorSaque = new BigDecimal(10000);
		 * doNothing().when(bancoMock).efetuarSaque(numeroConta, valorSaque);
		 * bancoMock.efetuarDeposito(numeroConta, valorSaque); CaixaVinteQuatroHoras
		 * caixa24horas = new CaixaVinteQuatroHoras(bancoMock);
		 * 
		 */

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(7777, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(101010, valorInicial);

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
	@Ignore
	@Test
	public void devePermitirSaldoFicarNegativoAteMilAoEfetuarSaqueEmContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		// BigDecimal valorSaque = new BigDecimal(10000);
		// Mockito.doThrow(SaldoInsuficienteException.class).when(bancoMock).efetuarSaque(numeroConta,
		// valorSaque);
		// bancoMock.efetuarSaque(numeroConta, valorSaque);

		BigDecimal valorInicial = new BigDecimal(1000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(456, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(789, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);
		BigDecimal valorSaqueConta456 = new BigDecimal(2000.0);

		BigDecimal valorSaqueConta789 = new BigDecimal(700.0);

		caixa24horas.efetuarSaque(456, valorSaqueConta456);

		caixa24horas.efetuarSaque(789, valorSaqueConta789);

		BigDecimal valorEsperadoConta456 = new BigDecimal(-1000.0);

		BigDecimal valorEsperadoConta789 = new BigDecimal(300.0);

		assertEquals(valorEsperadoConta456, caixa24horas.consultaSaldo(456));

		assertEquals(valorEsperadoConta789, caixa24horas.consultaSaldo(789));

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
