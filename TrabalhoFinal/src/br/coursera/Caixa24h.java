package br.coursera;

public class Caixa24h {
	
	Banco banco;
	
	
	public Caixa24h(Banco banco) {
		
		this.banco = banco;
		
		
	}
	
	public void consultarExtrato() {
		
		
		
	}
	public double consultarSaldo(Cliente cliente){
	

		if (banco.clientes.contains(cliente)) {
			
			//System.out.println(cliente.conta.getNumeroConta()+ " passou");
			
			System.out.println(cliente.conta + " passou");
			
			cliente.conta.consultarSaldo();
			
		}
		
		return 0;
		
		
		
	}
	public void realizarTransferencia() {
		
		
		
	}
	public void realizarDeposito() {
		
		
	}
	public void Sacar() {
		
		
		
	}

}
