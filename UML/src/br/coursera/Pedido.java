package br.coursera;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Date data;
	private boolean status = false;
	private int numero;
	private Dinheiro dinheiro;
	private Cheque cheque;
	private CartaoCredito cartaoCredito;
	private boolean pagamentoAceito = false;
    private DetalhePedido detalhePedido;
   // private Item item;


	List<Cliente> clientes = new ArrayList<Cliente>();

	public Pedido(Cliente cliente, Date data, boolean status, int numero, String formaPagamento, int limite) {
		
	   formaPagamento(formaPagamento,limite);
	   
	 //  adicionaItemPedido(item );

		this.data = data;
		this.status = status;
		this.numero = numero;
       // this.item = item;
		clientes.add(cliente);

	}

	public void formaPagamento(String Formapagamento, int limite) {
		
		if(Formapagamento.equals("dinheiro")) {
			
			dinheiro = new Dinheiro();
			dinheiro.getDinheiroOferecido();
			
			this.pagamentoAceito = true;
			
		}if(Formapagamento.equals("cheque")) {
			cheque = new Cheque();
		
			cheque.getNomeBanco();
			cheque.getIdBanco();
			cheque.getLimite();
			
		    cheque.getLimite();
		    
		    if(cheque.isAutorizado(limite)) {
		    	
		    	this.pagamentoAceito = true;
		    	this.status = true;
		    	
		    }
			
			
			
		}if(Formapagamento.equals("cartaoCredito")) {
			cartaoCredito = new CartaoCredito();
		
			cartaoCredito.getTipo();
			cartaoCredito.getNumero();
			cartaoCredito.getDataExp();
			cartaoCredito.getLimite();
			
		if(	cartaoCredito.isAutorizado(limite)) {
			
			this.pagamentoAceito = true;
	    	this.status = true;

		}
			
		
			
		}
	

		
		
	}
	
	public void adicionaItemPedido(Item item ) {
		
		detalhePedido = new DetalhePedido(item);
		//this.item = item;
		
		detalhePedido.calculaPeso();
		detalhePedido.calculaSubTotal();
		detalhePedido.isStatusImposto();
		System.out.println("quantidade: " + detalhePedido.getQuantidade() + "peso: " + detalhePedido.getPeso() + "Status Imposto: " + detalhePedido.isStatusImposto() + " Sub Total: " + detalhePedido.getSubTotal() );
		
		
	}

	public double calculaTaxa() {
		return 0;

	}

	public double calculaTotal() {
		return 0;

	}

	public double calculaTotalPeso() {
		return 0;

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public boolean isPagamentoAceito() {
		return pagamentoAceito;
	}

	public void setPagamentoAceito(boolean pagamentoAceito) {
		this.pagamentoAceito = pagamentoAceito;
	}

	public DetalhePedido getDetalhePedido() {
		return detalhePedido;
	}

	public void setDetalhePedido(DetalhePedido detalhePedido) {
		this.detalhePedido = detalhePedido;
	}

	


	
	

}