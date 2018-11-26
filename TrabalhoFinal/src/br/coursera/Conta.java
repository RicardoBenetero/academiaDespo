package br.coursera;

public class Conta {
	
	private Double saldo;
	private String numeroConta;
	private Cliente cliente;
	
	public Conta(Cliente cliente, String numeroConta) {
		
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		
	}
			
			
	
    public void consultarExtrato() {
		
		
		
	}
	public double consultarSaldo(){
		
		return saldo;
	}
	public void realizarTransferencia() {
		
		
		
	}
	public void realizarDeposito(Double valor) {
		this.saldo = saldo + valor;
		
	}
	public void Sacar() {
		
		
		
	}

}
