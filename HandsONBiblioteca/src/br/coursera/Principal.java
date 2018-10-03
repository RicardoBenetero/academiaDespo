package br.coursera;

public class Principal {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();

		Livro livro1 = new Livro();

		livro1.setCodigo("1234");

		Usuario usuario = new Usuario();

		usuario.setNome("Marcela");

		biblioteca.adicionarLivros(livro1);

		usuario.anexaLivroAListaDeLivrosEmprestados(livro1);

		livro1.anexaUsuarioDoEmprestimo(usuario);

		Livro livro2 = new Livro();

		livro2.setCodigo("86985");

		Usuario usuario2 = new Usuario();

		usuario2.setNome("Joana");

		biblioteca.adicionarLivros(livro2);

		usuario2.anexaLivroAListaDeLivrosEmprestados(livro2);

		livro2.anexaUsuarioDoEmprestimo(usuario2);

		Usuario usuario3 = new Usuario();

		usuario3.setNome("Marcia");

		biblioteca.adicionarLivros(livro2);

		usuario3.anexaLivroAListaDeLivrosEmprestados(livro2);
		System.out.println(
				"-----------------------------------a partir do usuario apresenta seus livros ------------------");

		System.out.println("livros do usuario(a):  " + usuario.getNome() + " Livro(s) código(s): - "
				+ usuario.getLivros().iterator().next().getCodigo());

		System.out.println("livros do usuario(a):  " + usuario2.getNome() + " Livro(s) código(s): -  "
				+ usuario2.getLivros().iterator().next().getCodigo());

		// System.out.println("livros do usuario(a): " + usuario3.getNome()+ " Livro(s)
		// código(s): - " +usuario3.getLivros().iterator().next().getCodigo());
		System.out.println(
				"-----------------------------------a partir do livro apresenta para quem está emprestado ------------------");

		System.out.println("Livro(s) código(s): - " + livro1.getUsuario().getLivros().iterator().next().getCodigo()
				+ "-  esta emprestado para usuario(a):  " + livro1.getUsuario().getNome());

		System.out.println("Livro(s) código(s): - " + livro2.getUsuario().getLivros().iterator().next().getCodigo()
				+ "-  esta emprestado para usuario(a):  " + livro2.getUsuario().getNome());
		//------------------------

		Livro livro3 = new Livro();

		livro3.setCodigo("636");
		
		biblioteca.adicionarLivros(livro3);
		
		
		
		//
		
		Biblioteca biblioteca1 = new Biblioteca();

		Livro livro1234 = new Livro();

		livro1234.setCodigo("1234");

		Usuario usuario5 = new Usuario();
		
		biblioteca.registraUsuario(usuario5);

		biblioteca.adicionarLivros(livro1234);

		biblioteca.emprestaLivro(livro1234);
		
		
		Livro livro636 = new Livro();

		livro636.setCodigo("636");

		Usuario usuario6 = new Usuario();
		
		biblioteca.registraUsuario(usuario6);

		biblioteca.adicionarLivros(livro636);

		biblioteca.emprestaLivro(livro636);
		
		
		Livro livro758 = new Livro();

		livro758.setCodigo("758");
		
		biblioteca.adicionarLivros(livro758);
		
		System.out.println(
				"-----------------------------------livros disponiveis para emprestimo ------------------");

		biblioteca.exibeLivrosDisponiveisEmprestimo();
		
		System.out.println(
				"-----------------------------------livros Indisponiveis para emprestimo ------------------");
		biblioteca.exibeLivrosIndisponiveisEmprestimo();
		
	}

}
