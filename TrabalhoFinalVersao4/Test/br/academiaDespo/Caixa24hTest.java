package br.academiaDespo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.academiaDespo.Banco.Banco;
import br.academiaDespo.Banco.Conta;
import br.academiaDespo.Caixa.Caixa24h;
import br.academiaDespo.Excecoes.ContaInexistenteException;

public class Caixa24hTest {
	
	@Test
	public void deveraRetornarSaldoZeradoQuandoNenhumDepositoFeito() throws ContaInexistenteException {

		List<Conta> contas = new ArrayList<Conta>();

		Conta contaCorrenteTeste = new ContaCorrenteTeste("1234");

		contas.add(contaCorrenteTeste);

		Banco bancoTeste = new BancoTeste(contas);

		Caixa24h atm = new Caixa24h(bancoTeste);
		
		BigDecimal valorEsperado = new BigDecimal("0.0");
		
		System.out.println(atm.consultarSaldo("1234"));

		assertEquals(valorEsperado, atm.consultarSaldo("1234"));

	}

}
