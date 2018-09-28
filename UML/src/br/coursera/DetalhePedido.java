package br.coursera;

public class DetalhePedido {
	
	private int quantidade;
	private boolean statusImposto;
	private Item item;
	private double subTotal;
	private double peso;
	
	
	public DetalhePedido(Item item) {
		this.item = item;
		
		
	}
	
	public double calculaSubTotal() {
		
		subTotal =	item.getPreco();

		statusImposto = true;
		return subTotal;
		
		
		
	}
	
	public double calculaPeso() {
		
		peso =   item.getPeso();
		return peso;
		
		
		
	}

	public int getQuantidade() {
		
		quantidade = item.getQuantidade();
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatusImposto() {
		return statusImposto;
	}

	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
