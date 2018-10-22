package br.coursera;

public class Oracle implements Conexao {

	@Override
	public void rollback() {
		System.out.println("rollback oracle");
	}

	@Override
	public void commit() {
		System.out.println("commit oracle");

	}

	@Override
	public void connect() {
		System.out.println("connect oracle");

	}

}
