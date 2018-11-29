package br.coursera;

public class BancoBeta implements Banco {
	
    private final static String BANCOBETA = "BANCOBETA";
	private Conta  contaCorrenteBancoBeta;
	private Cliente cliente;
	
	
	 public BancoBeta(Conta contaCorrenteBancoBeta) {
	    	
	    	
	    	this.contaCorrenteBancoBeta= contaCorrenteBancoBeta;
	    	this.cliente = cliente;
	    	contas.add(contaCorrenteBancoBeta.getNumeroConta());
	    }
	
	public String getNome() {
		
		return BANCOBETA;
		
	}

	@Override
	public void consultarExtrato() {
		contaCorrenteBancoBeta.consultarExtrato();		
	}

	@Override
	public double consultarSaldo(String numeroConta) throws SaldoInsuficienteException {
		
		if(contas.contains(numeroConta)) {
			System.out.println("aqui"); 
			return	contaCorrenteBancoBeta.consultarSaldo();
			
		}else {
			
			
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	
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
