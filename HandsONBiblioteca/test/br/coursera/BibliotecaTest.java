package br.coursera;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void quantidadeZeroQuandoNovaBiblioteca() {

		Biblioteca biblioteca = new Biblioteca();

		assertEquals(0, biblioteca.quantidadeUsuariosRegistrados());

	}

	@Test
	public void quantidadeUmQuandoUsuarioRegistrado() {

		Biblioteca biblioteca = new Biblioteca();

		biblioteca.registraUsuario(new Usuario());

		assertEquals(1, biblioteca.quantidadeUsuariosRegistrados());

	}

	@Test
	public void quantidadeZeroLivrosQuandoNovaBiblioteca() {

		Biblioteca biblioteca = new Biblioteca();

		assertEquals(0, biblioteca.quantidadeLivrosAdicionados());

	}

	@Test
	public void quantidadeUmLivrosAdicionados() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		biblioteca.adicionarLivros(livro);

		assertEquals(1, biblioteca.quantidadeLivrosAdicionados());

	}

	@Test
	public void usuarioPegaUmLivroQuantidadeDeveSerUM() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.adicionarLivros(livro);

		usuario.anexaLivroAListaDeLivrosEmprestados(livro);

		assertEquals(1, usuario.getQuantidadeLivros());

	}

	@Test
	public void marcaLivroComoEmprestadoQuandoUsuarioPega() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.registraUsuario(usuario);

		biblioteca.adicionarLivros(livro);

		biblioteca.emprestaLivro(livro);

		assertEquals(true, livro.emprestado);

	}

	@Test
	public void desmarcaLivroEmprestadoQuandoUsuarioDevolve() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.registraUsuario(usuario);

		biblioteca.adicionarLivros(livro);

		biblioteca.emprestaLivro(livro);

		biblioteca.devolveLivro(livro);

		assertEquals(false, livro.emprestado);

	}

	@Test
	public void apresentaLivrosdisponiveisParaEmprestimo() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.registraUsuario(usuario);

		biblioteca.adicionarLivros(livro);

		biblioteca.emprestaLivro(livro);

		Livro livro2 = new Livro();

		livro2.setCodigo("636");

		Usuario usuario2 = new Usuario();

		biblioteca.registraUsuario(usuario2);

		biblioteca.adicionarLivros(livro2);

		biblioteca.emprestaLivro(livro2);

		Livro livro3 = new Livro();

		livro3.setCodigo("845");

		biblioteca.adicionarLivros(livro3);
		
		Livro livro4 = new Livro();

		livro4.setCodigo("633");

		biblioteca.adicionarLivros(livro4);
		
		List<String> codigos = new ArrayList<String>();
		
		codigos.add("845");
		codigos.add("633");

		assertEquals(codigos, biblioteca.exibeLivrosDisponiveisEmprestimo());

	}
	
	@Test
	public void apresentaLivrosIndisponiveisParaEmprestimo() {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.registraUsuario(usuario);

		biblioteca.adicionarLivros(livro);

		biblioteca.emprestaLivro(livro);

		Livro livro2 = new Livro();

		livro2.setCodigo("636");

		Usuario usuario2 = new Usuario();

		biblioteca.registraUsuario(usuario2);

		biblioteca.adicionarLivros(livro2);

		biblioteca.emprestaLivro(livro2);

		Livro livro3 = new Livro();

		livro3.setCodigo("846");

		biblioteca.adicionarLivros(livro3);
		
		Livro livro4 = new Livro();

		livro4.setCodigo("634");

		biblioteca.adicionarLivros(livro4);
		
		
        List<String> codigos = new ArrayList<String>();
		
		codigos.add("1234");
		codigos.add("636");

		assertEquals(codigos, biblioteca.exibeLivrosIndisponiveisEmprestimo());

	}

}
