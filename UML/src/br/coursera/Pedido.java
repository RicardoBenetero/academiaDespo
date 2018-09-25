package br.coursera;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Date data;
	private boolean status;
	private int numero;
	
	Cliente cliente;
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	List<Pedido> pedidos = new ArrayList<Pedido>();

	
//	Cliente cliente;
	
	public Pedido(Cliente cliente, Date data, boolean status, int numero) {
		
		if (clientes.contains(clientes.get(0).getNome()=="Ana")) {
			System.out.println("O pedido jah pertence a outro cliente!");
		}else {
		this.data=data;
		this.status = status;
		this.numero = numero;
		clientes.add(cliente);
		}
		
	//	for (int i = 0; i <= clientes.size(); i++) {
	
			
		//	System.out.println("O pedido jah pertence a outro cliente!");
	//	}else
	       
	//		clientes.add(cliente);
		
		//this.cliente = cliente;
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







//	public Cliente getCliente() {
	//	return cliente;
//	}







	//public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}







	public List<Cliente> getClientes() {
		return clientes;
	}







	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


//	public List<Cliente> getClientes() {
//		return clientes;
//	}

	

	

	
	
	

}
