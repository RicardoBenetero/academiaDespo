package br.coursera;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
	
	String nome;
	
private Collection<Livro> livros;

private int quantidadeLivros;

public Usuario() {
	
	this.livros = new ArrayList<>();
	
}
	
	
	public void anexaLivroAListaDeLivrosEmprestados(Livro livro) {
		
		if(!livro.emprestado) {
		livros.add(livro);
		livro.emprestado = true;
		quantidadeLivros ++;
		
	}else {
		
		livro.setMensagemIndisponivel("Usuario(a): "+ getNome( ) +" Livro indisponivel no momento. Aguarde devolucao.") ;
				
	}
		
	}


   public void desanexaLivroDaListadeLivrosEmprestados(Livro livro) {
	   
	   livros.remove(livro);
	   livro.emprestado = false;
	   quantidadeLivros --;
	
	
}

	public int getQuantidadeLivros() {
		return quantidadeLivros;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Collection<Livro> getLivros() {
		return livros;
	}

}
