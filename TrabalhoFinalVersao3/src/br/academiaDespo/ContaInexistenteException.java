package br.academiaDespo;

public class ContaInexistenteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContaInexistenteException(String msg) {
		super(msg);
	}
}
