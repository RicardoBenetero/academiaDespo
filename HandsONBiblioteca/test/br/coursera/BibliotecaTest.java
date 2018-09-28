package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void quantidadeZeroQuandoNovaBiblioteca() {
		
	Biblioteca	biblioteca =  new Biblioteca();
	
	assertEquals(0,biblioteca.quantidadeUsuariosRegistrados());
		
		
		
	}
	
	@Test
	public void quantidadeUmQuandoUsuarioRegistrado() {
		
	Biblioteca	biblioteca =  new Biblioteca();
	
	biblioteca.registraUsuario(new Usuario());
	
	assertEquals(1,biblioteca.quantidadeUsuariosRegistrados());
		
		
		
	}
	
	@Test
	public void quantidadeZeroLivrosQuandoNovaBiblioteca() {
		
	Biblioteca	biblioteca =  new Biblioteca();
	
	
	assertEquals(0,biblioteca.quantidadeLivrosAdicionados());
		
		
		
	}
	
	@Test
	public void quantidadeUmLivrosAdicionados() {
		
	Biblioteca	biblioteca =  new Biblioteca();
	
    Livro livro = new Livro();
	
	biblioteca.adicionarLivros(livro);
	
	assertEquals(1,biblioteca.quantidadeLivrosAdicionados());
		
		
		
	}
	
	@Test
	public void usuarioPegaUmLivroQuantidadeDeveSerUM() {
		
	Biblioteca	biblioteca =  new Biblioteca();
	
    Livro livro = new Livro();
    
    livro.setCodigo("1234");
    
    Usuario usuario = new Usuario();
	
	biblioteca.adicionarLivros(livro);
	
	usuario.anexaLivroAListaDeLivrosEmprestados(livro);
	
	
	assertEquals(1,usuario.getQuantidadeLivros());
		
		
		
	}


}
