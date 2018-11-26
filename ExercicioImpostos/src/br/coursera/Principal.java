package br.coursera;

public class Principal {

	public static void main(String[] args) {


		PessoaJuridica p = new PessoaJuridica("teste", 200.0, "1234");
		
		//System.out.println( p.calcularImposto());
		
		
		PessoaFisica p1 = new PessoaFisica("teste2", 8000.01, "1234");

		System.out.println( p1.calcularImposto());

		
		
	}

}
