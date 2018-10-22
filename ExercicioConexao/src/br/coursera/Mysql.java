package br.coursera;

public class Mysql implements Conexao {

	@Override
	public void rollback() {
		System.out.println("rollback Mysql");
	}

	@Override
	public void commit() {
		System.out.println("commit Mysql");

	}

	@Override
	public void connect() {
		System.out.println("connect Mysql");

	}
}
