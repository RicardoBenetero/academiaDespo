package br.academiaDespo.Excecoes;

public class ContaInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContaInexistenteException(String msg) {
		super(msg);
	}
}
