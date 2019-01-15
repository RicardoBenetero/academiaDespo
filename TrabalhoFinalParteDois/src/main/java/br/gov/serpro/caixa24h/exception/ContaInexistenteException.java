package br.gov.serpro.caixa24h.exception;

public class ContaInexistenteException  extends Exception {
	
	public ContaInexistenteException (String msg) {
		super(msg);
	}
}