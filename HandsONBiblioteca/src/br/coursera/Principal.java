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

		System.out.println("livros do usuario(a):  " + usuario.getNome() + " Livro(s) c�digo(s): - "
				+ usuario.getLivros().iterator().next().getCodigo());

		System.out.println("livros do usuario(a):  " + usuario2.getNome() + " Livro(s) c�digo(s): -  "
				+ usuario2.getLivros().iterator().next().getCodigo());

		// System.out.println("livros do usuario(a): " + usuario3.getNome()+ " Livro(s)
		// c�digo(s): - " +usuario3.getLivros().iterator().next().getCodigo());
		System.out.println(
				"-----------------------------------a partir do livro apresenta para quem est� emprestado ------------------");

		System.out.println("Livro(s) c�digo(s): - " + livro1.getUsuario().getLivros().iterator().next().getCodigo()
				+ "-  esta emprestado para usuario(a):  " + livro1.getUsuario().getNome());

		System.out.println("Livro(s) c�digo(s): - " + livro2.getUsuario().getLivros().iterator().next().getCodigo()
				+ "-  esta emprestado para usuario(a):  " + livro2.getUsuario().getNome());

	}

}
