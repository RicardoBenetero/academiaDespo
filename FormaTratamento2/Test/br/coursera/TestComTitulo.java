package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestComTitulo {
	
	private FormatadorNome formatadorNome;
	private Autoridade autoridade;
	

	@Test
	public void deveRetornarTratamentoComTitulo() {
		formatadorNome = new ComTitulo("Pedro", "Cabral", "Magnifico");
		autoridade = new Autoridade(formatadorNome);
		
		assertEquals("Magnifico Pedro Cabral", autoridade.formatarNome("Pedro", "Cabral"));
	}

}
