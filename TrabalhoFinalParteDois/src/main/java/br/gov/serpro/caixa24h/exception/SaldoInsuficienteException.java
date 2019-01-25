package br.gov.serpro.caixa24h.exception;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = 1L;
	public SaldoInsuficienteException (String msg) {
		super(msg);
	}

}
