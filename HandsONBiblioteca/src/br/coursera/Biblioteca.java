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

		livroAdicionados.remove(livro);

	}

}
