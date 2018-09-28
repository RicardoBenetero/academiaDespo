package br.coursera;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
	
	
private Collection<Livro> livros;

private int quantidadeLivros;

public Usuario() {
	
	this.livros = new ArrayList<>();
	
}
	
	
	public void anexaLivroAListaDeLivrosEmprestados(Livro livro) {
		
		livros.add(livro);
		quantidadeLivros ++;
		
	}


	public int getQuantidadeLivros() {
		return quantidadeLivros;
	}

}
