package br.coursera;

import java.util.ArrayList;
import java.util.Collection;

public class Biblioteca {

	private Collection<Usuario> usuariosRegistrados;

	private Collection<Livro> livroAdicionados;

	public Biblioteca() {

		this.usuariosRegistrados = new ArrayList<>();
		this.livroAdicionados = new ArrayList<>();

	}

	public void registraUsuario(Usuario usuario) {
		usuariosRegistrados.add(usuario);

	}

	public int quantidadeUsuariosRegistrados() {
		return usuariosRegistrados.size();
	}

	public void adicionarLivros(Livro livro) {

		livroAdicionados.add(livro);

	}

	public int quantidadeLivrosAdicionados() {
		return livroAdicionados.size();
	}

	public void emprestaLivro(Livro livro) {
		usuariosRegistrados.iterator().next().anexaLivroAListaDeLivrosEmprestados(livro);
		livroAdicionados.remove(livro);

	}

	public void devolveLivro(Livro livro) {
		usuariosRegistrados.iterator().next().desanexaLivroDaListadeLivrosEmprestados(livro);
		livroAdicionados.add(livro);

	}

	public void exibeLivrosDisponiveisEmprestimo() {

		for (Livro livro : livroAdicionados) {

			if (livro.emprestado == false)
	
			System.out.println(livro.getCodigo());
		
			
			
		}

	}

	public void exibeLivrosIndisponiveisEmprestimo() {

		for (Livro livro : livroAdicionados) {

			if (livro.emprestado == true)

				System.out.println(livro.getCodigo());

		}

	}

}
