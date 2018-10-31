package br.coursera;

public class Informal implements FormatadorNome{
	String nome;
	String sobrenome;
	
	public Informal(String nome , String sobrenome){
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		return nome;
	}

}
