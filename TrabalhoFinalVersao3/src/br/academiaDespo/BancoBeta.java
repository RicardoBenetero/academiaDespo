package br.academiaDespo;

import java.util.ArrayList;
import java.util.List;

public class BancoBeta implements Banco {

	private final static String NOME = "BANCO BETA";
	List<Conta> contas = new ArrayList<Conta>();

	public BancoBeta(List<Conta> contas) {

		this.contas= contas;
	}

	@Override
	public String getNome() {

		return NOME;
	}

	@Override
	public List<String> consultarExtrato() {
		return contas.iterator().next().consultarExtrato();
		
		 
	}

	@Override
	public double consultarSaldo(String numero)throws ContaInexistenteException {
		
		if(contas.iterator().next().getNumero().equals(numero)){
			
			return contas.iterator().next().consultarSaldo(numero);
			
		
		
		
		}else{
		
			throw new ContaInexistenteException("Conta Inexistente");
		
		}
	}

	@Override
	public void realizarTransferencia(String numeroContadeposita,Double valor, String numeroContaRecebeDeposito) throws ContaInexistenteException{
		
		if(contas.iterator().next().getNumero().equals(numeroContadeposita)  ){
			System.out.println("classe banco beta " + numeroContadeposita);
		contas.iterator().next().realizarTransferencia(numeroContadeposita, valor, numeroContaRecebeDeposito);
		
		System.out.println("classe banco beta " + numeroContaRecebeDeposito + "valor " + valor);
	}else{
		
		throw new ContaInexistenteException("Conta Inexistente");
	}
		
	}

	@Override
	public void realizarDeposito(Conta conta,String numero,Double valor) throws ContaInexistenteException {

		
		if(conta.getNumero().equals(numero)){
			
			
			System.out.println(numero);
			
			for(Conta cont: contas){
				
				cont.realizarDeposito(conta, numero, valor);
				
			}
		}
		/*
		System.out.println(numero);
		if(contas.iterator().hasNext()){
			
				System.out.println("aqui");
				contas.iterator().next().realizarDeposito(numero,valor);
			
		}
		//realizarDeposito(numero, valor);
		
	//	for (int i = 0; i < contas.size();i++){
			
			//contas.get(i).realizarDeposito(numero, valor);
		//	System.out.println(numero);
		//}
		/*
		if(contas.iterator().next().getNumero().equals(numero)){
		
	
			
		contas.iterator().next().realizarDeposito(numero,valor);
			
		}else {
			throw new ContaInexistenteException("Conta Inexistente");
		
	
		
		}
		
		*/
	}

	@Override
	public void sacar(String numero,Double valor) throws ContaInexistenteException {
		if(contas.iterator().next().getNumero().equals(numero)){
		contas.iterator().next().sacar(numero,valor);
		}else{
			throw new ContaInexistenteException("Conta Inexistente");
			
		}
	}

}
