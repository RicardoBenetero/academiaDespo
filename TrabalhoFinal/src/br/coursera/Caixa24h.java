package br.coursera;

public class Caixa24h {
	
	Banco banco;
	Cliente cliente;
	
	public Caixa24h(Banco banco) {
		
		this.banco = banco;
		
		
	}
	
	public void consultarExtrato() {
		
		
		
	}
	public double consultarSaldo(Cliente cliente){
		
		if (banco.clientes.contains(cliente)) {
			
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
