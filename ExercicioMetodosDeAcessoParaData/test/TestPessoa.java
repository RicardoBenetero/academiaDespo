import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import br.coursera.Pessoa;
import br.coursera.Relogio;

public class TestPessoa {

	@Test
	public void deveRetornarIdadePessoaESignoCapricornio() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 01, 20);

		 Relogio relogio = new Relogio(1540692460660L);
		 
		//System.out.println(relogio.agora());
		
        

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(38, rita.getIdade());
		assertEquals("Capricornio", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoAquario() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 02, 19);

		// Relogio relogio = new Relogio(1);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(38, rita.getIdade());
		assertEquals("Aquario", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoAries() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 03, 21);

		// Relogio relogio = new Relogio(1);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(38, rita.getIdade());
		assertEquals("Aries", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoTouro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 04, 21);

		// Relogio relogio = new Relogio(1);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(38, rita.getIdade());
		assertEquals("Touro", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoGemeos() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 05, 21);

		// Relogio relogio = new Relogio(1);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(38, rita.getIdade());
		assertEquals("Gemeos", rita.getSigno());

	}

}
