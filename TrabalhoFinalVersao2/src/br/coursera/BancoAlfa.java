package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class BancoAlfa implements Banco{
    private final static String BANCOALFA = "BANCOALFA";
    private Conta  contaCorrenteBancoAlfa;
    private Cliente cliente;


    public BancoAlfa( Cliente cliente,Conta  contaCorrenteBancoAlfa) {
    	
    	
    	this.contaCorrenteBancoAlfa = contaCorrenteBancoAlfa;
    	this.cliente = cliente;
    
    }
   
    
	@Override
	public String getNome() {
		return BANCOALFA;
	}

	@Override
	public void consultarExtrato() {
		contaCorrenteBancoAlfa.consultarExtrato();		
	}

	@Override
	public double consultarSaldo() {
		return contaCorrenteBancoAlfa.consultarSaldo();
	}

	@Override
	public void realizarTransferencia(Conta contaDeposita, Double valor, Conta contaRecebeDeposito) {
		contaCorrenteBancoAlfa.realizarTransferencia(contaDeposita, valor, contaRecebeDeposito);		
	}

	@Override
	public void realizarDeposito(Double valor) {
		contaCorrenteBancoAlfa.realizarDeposito(valor);		
	}

	@Override
	public void sacar(Double valor) {
		contaCorrenteBancoAlfa.sacar(valor);		
	}

	

}
