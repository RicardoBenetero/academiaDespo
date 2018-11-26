package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente implements Conta{
	
	private Double saldo = 0.00;
	private String numeroConta;
	List<String> numerosConta = new ArrayList<String>();

	//private Cliente cliente;
	
	public ContaCorrente( String numeroConta) {
		
		for(String n: numerosConta){
			if(numerosConta.contains(numeroConta)){
				
				System.out.println("erro");
				
			}
			
		else{
		
		//this.cliente = cliente;
		//this.numeroConta = numeroConta;
			System.out.println("aqui");
		numerosConta.add(numeroConta);
		}
	//	for(String n: numerosConta){
		//	System.out.println(numerosConta);
			
		}
		for(String n: numerosConta){
				System.out.println(numerosConta);
		}
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



	public String getNumeroConta() {
		return numeroConta;
	}

}
