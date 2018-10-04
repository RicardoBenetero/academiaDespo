package br.coursera;

public class Principal2 {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();

		Livro livro = new Livro();

		livro.setCodigo("1234");

		Usuario usuario = new Usuario();

		biblioteca.registraUsuario(usuario);

		biblioteca.adicionarLivros(livro);

		biblioteca.emprestaLivro(livro);
		
		System.out.println("livro 1 " + livro.getCodigo() + "  " +livro.emprestado);

		Livro livro2 = new Livro();

		livro2.setCodigo("636");

		Usuario usuario2 = new Usuario();

		biblioteca.registraUsuario(usuario2);

		biblioteca.adicionarLivros(livro2);

		biblioteca.emprestaLivro(livro2);
		System.out.println("livro 2 " + livro2.getCodigo() +"  " +livro2.emprestado);

		Livro livro3 = new Livro();

		livro3.setCodigo("845");

		biblioteca.adicionarLivros(livro3);
		
		System.out.println("livro 3 " + livro3.getCodigo() +"   " +livro3.emprestado);
		
		
		Livro livro4 = new Livro();

		livro4.setCodigo("633");

		biblioteca.adicionarLivros(livro4);
		
		System.out.println("livro 4 " + livro4.getCodigo() + "   " +livro4.emprestado);


		
		System.out.println("---------------------Livros Disponiveis Para Emprestimo---------------------------");
		System.out.println(biblioteca.exibeLivrosDisponiveisEmprestimo());
	
		System.out.println("---------------------Livros indisponiveis Para Emprestimo---------------------------");

		System.out.println(biblioteca.exibeLivrosIndisponiveisEmprestimo());

	}

}
