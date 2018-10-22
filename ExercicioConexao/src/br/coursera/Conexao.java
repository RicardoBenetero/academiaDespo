package br.coursera;

public interface Conexao {

	public void rollback();

	public void commit();

	public void connect();

}
