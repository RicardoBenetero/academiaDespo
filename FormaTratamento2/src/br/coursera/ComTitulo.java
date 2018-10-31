package br.coursera;

public class ComTitulo implements FormatadorNome {
	private String nome, sobrenome;
	private String titulo;

	public ComTitulo(String nome, String sobrenome, String titulo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.titulo = titulo;

	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		return titulo + " " + nome + " " + sobrenome;
	}

}
