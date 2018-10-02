package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void devolveMensagemLivroIndisponivel() {
		Biblioteca biblioteca = new Biblioteca();

		Livro livro1 = new Livro();

		livro1.setCodigo("1234");

		Usuario usuario = new Usuario();

		usuario.setNome("Marcela");

		biblioteca.adicionarLivros(livro1);

		usuario.anexaLivroAListaDeLivrosEmprestados(livro1);

		Usuario usuario3 = new Usuario();

		usuario3.setNome("Marcia");

		biblioteca.adicionarLivros(livro1);

		usuario3.anexaLivroAListaDeLivrosEmprestados(livro1);

		assertEquals("Usuario(a): " + usuario3.getNome() + " Livro indisponivel no momento. Aguarde devolucao.",
				livro1.getMensagemIndisponivel());
	}

}
