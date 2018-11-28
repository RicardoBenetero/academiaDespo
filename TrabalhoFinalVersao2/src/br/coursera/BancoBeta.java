package br.coursera;

public class BancoBeta implements Banco {
	
	private String nome;
	private ContaCorrenteBancoBeta  contaCorrenteBancoBeta;
	
	
	 public BancoBeta(ContaCorrenteBancoBeta  contaCorrenteBancoBeta) {
	    	
	    	
	    	this.contaCorrenteBancoBeta= contaCorrenteBancoBeta;
	    }
	
	public String getNome() {
		
		return nome;
		
	}

	@Override
	public void consultarExtrato() {
		contaCorrenteBancoBeta.consultarExtrato();		
	}

	@Override
	public double consultarSaldo() {
		return contaCorrenteBancoBeta.consultarSaldo()	;	
	}

	@Override
	public void realizarTransferencia(Conta contaDeposita, Double valor, Conta contaRecebeDeposito) {
		contaCorrenteBancoBeta.realizarTransferencia(contaDeposita, valor, contaRecebeDeposito);	
	}

	@Override
	public void realizarDeposito(Double valor) {
		contaCorrenteBancoBeta.realizarDeposito(valor);		
	}

	@Override
	public void sacar(Double valor) {
		contaCorrenteBancoBeta.sacar(valor);		
	}

}
