package br.gov.serpro.caixa24h.exception;

public class BancoInexistenteException extends Exception {
	public BancoInexistenteException (String msg) {
		super(msg);
	}
}
