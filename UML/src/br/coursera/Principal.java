package br.coursera;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("24/09/2018");
		
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setNome("Ana");
		
		cliente1.setEndereco("Rua Marechal Freitas");
		
		
        Cliente cliente2 = new Cliente();
		
		cliente2.setNome("Joao");
		
		cliente2.setEndereco("Rua Marechal Freitas");
		
	//	List<Cliente>	clientes = new ArrayList<Cliente>();
		
		Pagamento dinheiro = new Dinheiro();
		
		Pagamento cheque = new Cheque();
		
		Pagamento cartaoCredito = new CartaoCredito();

        Item item1 = new Item();
		
		item1.setDescricao("guitarra");
		
		item1.setPesoEntrega(20);
		
	    item1.setQuantidade(2);
		
		item1.getPrecoPelaQuantidade(item1.getQuantidade(),"guitarra");
		
		item1.getPeso();
		
        // DetalhePedido detalhePedido = new DetalhePedido(item1);
		
		//detalhePedido.calculaPeso();
		
	    //detalhePedido.calculaSubTotal();
		
		
		Pedido pedido1 = new Pedido(cliente1, data, true,1,"cheque",3000);
		
		Pedido pedido2 = new Pedido(cliente2, data, true,3, "dinheiro",0);
		
		
		
		
		
		
		pedido1.setData(data);
	
		formato.format( pedido1.getData());
		
		pedido1.setStatus(true);
		
		pedido1.adicionaItemPedido(item1);
		//pedido1.formaPagamento("cheque", 3000);
		
		
		pedido2.setData(data);
		
		formato.format( pedido2.getData());
		
		pedido2.setStatus(false);
		
		
	
		

		
		System.out.println("Cliente 1 :  " + " Nome: " + pedido1.getClientes().get(0).getNome() + " Data Pedido: " + formato.format( pedido1.getData()) + " Situacao Pedido :" + " " + pedido1.isStatus()+ " numero pedido: " + pedido1.getNumero()+ " pagamento aceito : " + pedido1.isPagamentoAceito() + " pedido ativo: " + pedido1.isStatus()+ " detalhe pedido: " + pedido1.getDetalhePedido());
		
		System.out.println("Cliente 2 :  " + " Nome: " + pedido2.getClientes().get(0).getNome() + " Data Pedido: " + formato.format( pedido2.getData()) + " Situacao Pedido :" + " " + pedido2.isStatus()+" numero pedido: " + pedido2.getNumero() );
		
	//	System.out.println("Cliente 1 :  " + " Nome: " + pedido1.cliente.getNome() + " Data Pedido: " + formato.format( pedido1.getData()) + " Situacao Pedido :" + " " + pedido1.isStatus() );	

	}

}
