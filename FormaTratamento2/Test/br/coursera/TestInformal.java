package br.coursera;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import br.coursera.FormatadorNome;

public class TestInformal {
	
	
	private FormatadorNome formatadorNome;
	private Autoridade autoridade;
	
	@Before
	public void preparaMassa() {
		
		formatadorNome = new Informal("Marcia", "Tavares");
		autoridade = new Autoridade(formatadorNome);
		
		
		
	}

	@Test
	public void deveRetornarTratamentoInformal() {
		
		assertEquals("Marcia", autoridade.formatarNome("Marcia", "Tavares"));

		
	}

}
