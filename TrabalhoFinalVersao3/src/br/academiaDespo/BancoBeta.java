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
			
		contas.iterator().next().realizarTransferencia(numeroContadeposita, valor, numeroContaRecebeDeposito);
		
	}else{
		
		throw new ContaInexistenteException("Conta Inexistente");
	}
		
	}

	@Override
	public void realizarDeposito(String numero,Double valor) throws ContaInexistenteException {
        
		if(contas.iterator().next().getNumero().equals(numero)  ){
			
			contas.iterator().next().realizarDeposito(numero, valor);
		}  else
			throw new ContaInexistenteException("Conta Inexistente");
		
	
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
