package br.coursera;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Biblioteca {

	private Collection<Usuario> usuariosRegistrados;

	private Collection<Livro> livroAdicionados;

	private Collection<Livro> livrosIndisponiveis;

	public Biblioteca() {

		this.usuariosRegistrados = new ArrayList<>();
		this.livroAdicionados = new ArrayList<>();
		this.livrosIndisponiveis = new ArrayList<>();

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
		livrosIndisponiveis.add(livro);
		livroAdicionados.remove(livro);

	}

	public void devolveLivro(Livro livro) {
		usuariosRegistrados.iterator().next().desanexaLivroDaListadeLivrosEmprestados(livro);
		livroAdicionados.add(livro);

	}

	public List<String> exibeLivrosDisponiveisEmprestimo() {

		List<String> livrosDisponiveis = new ArrayList<String>();

		for (Livro livro : livroAdicionados) {

			if (!livro.emprestado) {

				livrosDisponiveis.add(livro.getCodigo());

			}

		}
		return livrosDisponiveis;
	}

	public List<String> exibeLivrosIndisponiveisEmprestimo() {

		List<String> livros = new ArrayList<String>();

		for (Livro livro : livrosIndisponiveis) {

			if (livro.emprestado) {

				livros.add(livro.getCodigo());

			}

		}

		return livros;
	}

}
