package br.coursera;

public class ContaEspecial extends ContaCorrente {
	
	
	int limite;
	
	public ContaEspecial ( int limite) {
		
		this.limite = limite;
		
	}
	
	public int sacar(int valor) {
		
		if (valor > (saldo+limite)) {
				return 0;
				
			}else{
				
				saldo -= valor;
				return valor;
			}
			
		}

}
