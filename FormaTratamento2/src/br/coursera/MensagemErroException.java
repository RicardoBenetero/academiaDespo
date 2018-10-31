package br.coursera;

public class MensagemErroException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MensagemErroException(String msg) {
		super(msg);
	}

}
