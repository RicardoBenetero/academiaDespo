package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class LivroTest {

	@Test
	public void anexaLivroAoUsuario() {

		Biblioteca biblioteca = new Biblioteca();
		Livro livro1 = new Livro();

		livro1.setCodigo("1234");

		Livro livro2 = new Livro();

		livro1.setCodigo("963");

		Usuario usuario = new Usuario();

		Usuario usuario2 = new Usuario();

		usuario.setNome("Marcela");

		usuario2.setNome("Joana");

		biblioteca.adicionarLivros(livro1);

		biblioteca.adicionarLivros(livro2);

		usuario.anexaLivroAListaDeLivrosEmprestados(livro1);

		usuario2.anexaLivroAListaDeLivrosEmprestados(livro2);

		livro1.anexaUsuarioDoEmprestimo(usuario);

		livro2.anexaUsuarioDoEmprestimo(usuario2);

		System.out.println();

		assertEquals("Marcela", livro1.getUsuario().getNome());

		
	}

}
