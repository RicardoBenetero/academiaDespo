package br.coursera;

public class Item {
	
	private double pesoEntrega;
	private String descricao;
	private double preco;
	private int quantidade;
	
	
	public double getPrecoPelaQuantidade(int quantidade, String descricao) {
		
		if (descricao.equals("guitarra")) {
			
			preco = 1000;
		}if (descricao.equals("violao")) {
			
			preco = 500;
		}if (descricao.equals("amplificador")) {
			
			preco = 200;
		}
		
		this.preco = preco * quantidade;
		return preco;
		
		
		
	}
	
	public double getPeso() {
		return pesoEntrega;
		
		
	}

	public void setPesoEntrega(double pesoEntrega) {
		this.pesoEntrega = pesoEntrega;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
