package br.coursera;

public class Respeitoso implements FormatadorNome {

	public final static int FEMININO = 0;
	public final static int MASCULINO = 1;
	private String nome, sobrenome;
	private int sexo;

	public Respeitoso(String nome, String sobrenome, int sexo) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;

	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		if (sexo == FEMININO)
			return "Sra. " + sobrenome;
		if (sexo == MASCULINO)
			return "Sr. " + sobrenome;
		throw new MensagemErroException("Sexo incorreto");

	}
}
