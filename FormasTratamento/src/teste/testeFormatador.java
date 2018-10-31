package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Autoridade;
import src.MensagemErroException;

public class testeFormatador {

	@Test
	public void deveRetornarTratamentoInformal() {
		Autoridade autoridade = new Autoridade("Marcia", "Tavares");
		assertEquals("Marcia", autoridade.getTratamento());
	}

	@Test
	public void deveRetornarTratamentoRespeitosoFeminino() {
		Autoridade autoridade = new Autoridade("Marcia", "Tavares", Autoridade.FEMININO);
		assertEquals("Sra. Tavares", autoridade.getTratamento());
	}

	@Test
	public void deveRetornarTratamentoRespeitosoMasculino() {
		Autoridade autoridade = new Autoridade("Joao", "Tavares", Autoridade.MASCULINO);
		assertEquals("Sr. Tavares", autoridade.getTratamento());
	}

	@Test
	public void deveRetornarTratamentoComTitulo() {
		Autoridade autoridade = new Autoridade("Pedro", "Cabral", "Magnifico");
		assertEquals("Magnifico Pedro Cabral", autoridade.getTratamento());
	}

	@Test(expected = MensagemErroException.class)
	public void deveRetornarTratamentoRespeitosoException() {
		Autoridade autoridade = new Autoridade("Joao", "Tavares", 3);
		autoridade.getTratamento();
	}

}
