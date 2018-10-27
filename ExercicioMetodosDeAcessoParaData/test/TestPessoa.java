import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import br.coursera.Pessoa;
import br.coursera.Relogio;

public class TestPessoa {

	@Test
	public void deveRetornarIdadePessoaESigno() {
		
		LocalDate dataNascimentoRita = LocalDate.of(1951, 8, 20); 
		
		Relogio relogio = new Relogio(0);
		
		System.out.println(relogio.agora());
		
		
		
		Pessoa rita = new Pessoa(dataNascimentoRita);
		
		System.out.println(rita.mes());
		
		assertEquals(67,rita.getIdade());
		assertEquals("Leao",rita.getSigno());

	}

}
