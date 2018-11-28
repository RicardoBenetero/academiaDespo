package br.coursera;

public class BancoAlfa implements Banco{
    private String nome;
    private ContaCorrenteBancoAlfa  contaCorrenteBancoAlfa;
    
    
    public BancoAlfa(ContaCorrenteBancoAlfa  contaCorrenteBancoAlfa) {
    	
    	
    	this.contaCorrenteBancoAlfa= contaCorrenteBancoAlfa;
    }
   
    
	@Override
	public String getNome() {
		return nome;
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
