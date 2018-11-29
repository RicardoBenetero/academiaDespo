package br.academiaDespo;

public class SaldoInsuficienteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}
