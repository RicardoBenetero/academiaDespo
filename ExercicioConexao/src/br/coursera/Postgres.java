package br.coursera;

public class Postgres implements Conexao {

	@Override
	public void rollback() {
		System.out.println("rollback Postgres");
	}

	@Override
	public void commit() {
		System.out.println("commit Postgres");

	}

	@Override
	public void connect() {
		System.out.println("connect Postgres");

	}

}
