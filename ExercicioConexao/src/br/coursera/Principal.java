package br.coursera;

public class Principal {

	public static void main(String[] args) {
		
		Conexao bancoConexao =  new Oracle();
		
		conectar(bancoConexao);
		
			

	

}
	
	public static void conectar(Conexao c) {
		
		c.connect();
		c.commit();
		c.rollback();
	}
}
