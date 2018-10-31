package br.coursera;

public class Autoridade implements FormatadorNome {
	
	
	
	FormatadorNome formatadorNome;
	
	
	public Autoridade (FormatadorNome formatadorNome){
		
		this.formatadorNome = formatadorNome;
		
	}


	@Override
	public String formatarNome(String nome, String sobrenome) {
		
		return formatadorNome.formatarNome(nome, sobrenome);
	}
	


}
