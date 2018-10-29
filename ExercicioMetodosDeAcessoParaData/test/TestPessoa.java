import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

import br.coursera.Pessoa;
import br.coursera.Relogio;

public class TestPessoa {

	@Test
	public void deveRetornarIdadePessoaESignoCapricornioJaneiro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 01, 20);

		Relogio relogio = new Relogio(1540692460660L);

		// System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Capricornio", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoCapricornioDezembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 12, 22);

		Relogio relogio = new Relogio(1540767518440L);
		
		//System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = (anoDataAtual - 1) - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Capricornio", rita.getSigno());

	}

	@Test
	public void deveRetornarIdadePessoaESignoAquarioFevereiro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 02, 19);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Aquario", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoAquarioJaneiro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 01, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Aquario", rita.getSigno());

	}

	@Test
	public void deveRetornarIdadePessoaESignoAriesMarco() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 03, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Aries", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoAriesAbril() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 04, 20);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);

		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Aries", rita.getSigno());

	}


	@Test
	public void deveRetornarIdadePessoaESignoTouroAbril() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 04, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Touro", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoTouroMaio() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 05, 20);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Touro", rita.getSigno());

	}

	@Test
	public void deveRetornarIdadePessoaESignoGemeosMaio() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 05, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Gemeos", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoGemeosJunho() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 06, 20);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Gemeos", rita.getSigno());

	}
	
	
	@Test
	public void deveRetornarIdadePessoaESignoCancerJunho() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 06, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Cancer", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoCancerJulho() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 07, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Cancer", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoLeaoJulho() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 07, 22);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Leao", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoLeaoAgosto() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 8, 22);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Leao", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoVirgemAgosto() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 8, 23);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Virgem", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoVirgemsetembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 9, 22);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Virgem", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoLibraSetembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 9, 23);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Libra", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoLibraOutubro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 10, 22);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Libra", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoEscorpiaoOutubro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 10, 23);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Escorpiao", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoEscorpiaonovembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 11, 21);

		Relogio relogio = new Relogio(1540692460660L);

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = (anoDataAtual - 1)  - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Escorpiao", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoSargitarioNovembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 11, 22);

		Relogio relogio = new Relogio(1540767518440L);
		
		//System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = (anoDataAtual - 1) - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Sargitario", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoSargitarioDezembro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 12, 21);

		Relogio relogio = new Relogio(1540767518440L);
		
		//System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = (anoDataAtual - 1) - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Sargitario", rita.getSigno());


	}
	
	@Test
	public void deveRetornarIdadePessoaESignoPeixesFevereiro() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 02, 20);

		Relogio relogio = new Relogio(1540767518440L);
		
		//System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual  - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Peixes", rita.getSigno());

	}
	
	@Test
	public void deveRetornarIdadePessoaESignoPeixesMarco() {

		LocalDate dataNascimentoRita = LocalDate.of(1980, 03, 20);

		Relogio relogio = new Relogio(1540767518440L);
		
		//System.out.println(relogio.agora());

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(relogio.agora()), ZoneId.systemDefault());

		int anoDataAtual = date.getYear();
		int anoDataDeNascimento = dataNascimentoRita.getYear();

		int idadeNoMomentoDoteste = anoDataAtual  - anoDataDeNascimento;

		// System.out.println(idadeNoMomentoDoteste);

		Pessoa rita = new Pessoa(dataNascimentoRita);
		assertEquals(idadeNoMomentoDoteste, rita.getIdade());
		assertEquals("Peixes", rita.getSigno());

	}
	

}
