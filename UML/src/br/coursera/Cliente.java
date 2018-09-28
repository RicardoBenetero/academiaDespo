package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String endereco;
	
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	public void adicionaPedidosDoCliente(Pedido pedido) {
		
		this.pedidos.add(pedido);
		
	}
	
	public void mostraPedidosCliente() {
		for(int i =0;i < pedidos.size();i++)
		{
			
		System.out.println ("Nome Cliente: " + getNome() + "| Numero Pedido: " +pedidos.get(i).getNumero());
		
		
		}
		}	
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
