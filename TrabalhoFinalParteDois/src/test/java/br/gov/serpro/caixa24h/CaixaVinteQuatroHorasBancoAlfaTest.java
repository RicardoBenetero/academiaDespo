package br.gov.serpro.caixa24h;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import br.gov.serpro.banco.BancoGeral;
import br.gov.serpro.banco.Extrato;
import br.gov.serpro.bancoAlfa.BancoAlfa;
import br.gov.serpro.bancoAlfa.ContaBancoAlfa;
import br.gov.serpro.bancoAlfa.ContaCorrenteComumBancoAlfa;
import br.gov.serpro.bancoAlfa.ContaCorrenteEspecialBancoAlfa;
import br.gov.serpro.caixa24h.exception.BancoInexistenteException;
import br.gov.serpro.caixa24h.exception.ContaInexistenteException;
import br.gov.serpro.caixa24h.exception.LimiteDeOperacoesPorDiaAtingidoException;
import br.gov.serpro.caixa24h.exception.SaldoInsuficienteException;

public class CaixaVinteQuatroHorasBancoAlfaTest {

	BancoGeral bancoMock = Mockito.mock(BancoGeral.class);
	private int numeroConta;
	private int contaDestino;
	private Extrato extrato;

	@Before
	public void inicializa() {
		numeroConta = 123456;
		contaDestino = 12345678;
	}

	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		

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

		LocalDate dataHoje = LocalDate.now();

		assertEquals("Saque", caixa24horas.consultaExtrato(7777).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(7777).iterator().next().getData());
		assertEquals(valorSaqueConta7777, caixa24horas.consultaExtrato(7777).iterator().next().getDebito());

		assertEquals("Saque", caixa24horas.consultaExtrato(101010).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(101010).iterator().next().getData());
		assertEquals(valorSaqueConta101010, caixa24horas.consultaExtrato(101010).iterator().next().getDebito());

	}

	@Test
	public void deveRetornarUmaConsultaDoExtratoParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

		BigDecimal valorInicial = new BigDecimal(10000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(234, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(567, valorInicial);

		contas.add(contaCorrenteTeste);

		contas.add(contaCorrenteTeste2);
		BancoGeral bancoAlfa = new BancoAlfa(contas);

		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(bancoAlfa);
		BigDecimal valorSaqueConta234 = new BigDecimal(500.0);

		BigDecimal valorSaqueConta567 = new BigDecimal(700.0);

		caixa24horas.efetuarSaque(234, valorSaqueConta234);

		caixa24horas.efetuarSaque(567, valorSaqueConta567);

		LocalDate dataHoje = LocalDate.now();

		assertEquals("Saque", caixa24horas.consultaExtrato(234).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(234).iterator().next().getData());
		assertEquals(valorSaqueConta234, caixa24horas.consultaExtrato(234).iterator().next().getDebito());

		assertEquals("Saque", caixa24horas.consultaExtrato(567).iterator().next().getOperacao());
		assertEquals(dataHoje, caixa24horas.consultaExtrato(567).iterator().next().getData());
		assertEquals(valorSaqueConta567, caixa24horas.consultaExtrato(567).iterator().next().getDebito());

	}

	@Test(expected = ContaInexistenteException.class)
	public void naoDevePermitirNumeroContaInexistenteParaConsultaExtrato()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

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

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarTransferenciaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
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

	@Test(expected = SaldoInsuficienteException.class)
	public void naoDevePermitirSaldoInsuficienteAoEfetuarSaqueParaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {

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

	@Test(expected = BancoInexistenteException.class)
	public void deveRetornarExcecaoQuandoInformadoBancoNulo()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		CaixaVinteQuatroHoras caixa24horas = new CaixaVinteQuatroHoras(null);
		caixa24horas.consultaExtrato(123456);

	}

	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test
	public void deveRetornarSaldoAoInformarNumeroDaContaComum() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(6000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteEspecialBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteEspecialBancoAlfa(7878, valorInicial);

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

	@Test
	public void deveRetornarSeTransferenciaFoiEfetuadaComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {

		
		BigDecimal valorInicial = new BigDecimal(10000.0);

		BigDecimal valorTransferencia = new BigDecimal(6000.0);

		List<ContaBancoAlfa> contas = new ArrayList<ContaBancoAlfa>();

		ContaBancoAlfa contaCorrenteTeste = new ContaCorrenteComumBancoAlfa(2323, valorInicial);

		ContaBancoAlfa contaCorrenteTeste2 = new ContaCorrenteComumBancoAlfa(7878, valorInicial);

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
	public void deveRetornarSeDepositoEfetuadoComSucesso() throws ContaInexistenteException {
		BigDecimal valorDepositado = new BigDecimal(10000);
		doNothing().when(bancoMock).efetuarDeposito(numeroConta, valorDepositado);
		bancoMock.efetuarDeposito(numeroConta, valorDepositado);
	}

	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaEspecial() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test
	public void deveRetornarSeSaqueEfetuadoComSucessoParaContaComum() throws SaldoInsuficienteException,
			ContaInexistenteException, BancoInexistenteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test
	public void devePermitirSaldoFicarNegativoAteMilAoEfetuarSaqueEmContaEspecial() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {
		
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

	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_ConsultaSaldo()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_EfetuarSaque() throws ContaInexistenteException,
			BancoInexistenteException, SaldoInsuficienteException, LimiteDeOperacoesPorDiaAtingidoException {


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

	@Test(expected = LimiteDeOperacoesPorDiaAtingidoException.class)
	public void naoDevePermitirRealizarMaisDeTresOperacoesDiaContaComum_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

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
	
    @Test
	public void devePermitirRealizarMaisDeTresOperacoesDiaContaEspecial_EfetuarTransferencia()
			throws ContaInexistenteException, BancoInexistenteException, SaldoInsuficienteException,
			LimiteDeOperacoesPorDiaAtingidoException {

	
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
