package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestRespeitoso {
	
	private FormatadorNome formatadorNome;
	private Autoridade autoridade;
	
	

	@Test
	public void deveRetornarTratamentoRespeitosoFeminino() {
		
		formatadorNome = new Respeitoso("Marcia", "Tavares",Respeitoso.FEMININO);
		autoridade = new Autoridade(formatadorNome);
		assertEquals("Sra. Tavares", autoridade.formatarNome("Marcia", "Tavares"));
		
		
	}
	
	
	@Test
	public void deveRetornarTratamentoRespeitosoMasculino() {
		
		formatadorNome = new Respeitoso("Joao", "Tavares",Respeitoso.MASCULINO);
		autoridade = new Autoridade(formatadorNome);
		assertEquals("Sr. Tavares", autoridade.formatarNome("Joao", "Tavares"));
	}
	
	@Test(expected = MensagemErroException.class)
	public void deveRetornarTratamentoRespeitosoException() {
		formatadorNome = new Respeitoso("Joao", "Tavares",3);
		autoridade = new Autoridade(formatadorNome);

		autoridade.formatarNome("Joao", "Tavares");
	
	}

}
