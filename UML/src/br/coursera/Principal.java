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
		
		 Item item2 = new Item();
			
			item2.setDescricao("violao");
			
			item2.setPesoEntrega(15);
			
		    item2.setQuantidade(2);
			
			item2.getPrecoPelaQuantidade(item2.getQuantidade(),"violao");
			
			item2.getPeso();
			
			 Item item3 = new Item();
				
				item3.setDescricao("violao");
				
				item3.setPesoEntrega(20);
				
			    item3.setQuantidade(3);
				
				item3.getPrecoPelaQuantidade(item3.getQuantidade(),"amplificador");
				
				item3.getPeso();
		
        // DetalhePedido detalhePedido = new DetalhePedido(item1);
		
		//detalhePedido.calculaPeso();
		
	    //detalhePedido.calculaSubTotal();
		
		
		Pedido pedido1 = new Pedido(cliente1, data,1,"cheque",3000);
		
		Pedido pedido2 = new Pedido(cliente2, data,3, "dinheiro",0);
		
		Pedido pedido3 = new Pedido(cliente2, data,4, "cartaoCredito",500);

		
		
		
		
		
		
		pedido1.setData(data);
	
		formato.format( pedido1.getData());
		
		pedido1.setStatus(true);
		
		//pedido1.adicionaItemPedido(item1);
		//pedido1.formaPagamento("cheque", 3000);
		
		
		pedido2.setData(data);
		
		formato.format( pedido2.getData());
		
		pedido2.setStatus(true);
		
		
		cliente1.adicionaPedidosDoCliente(pedido1);
		cliente2.adicionaPedidosDoCliente(pedido2);
		cliente2.adicionaPedidosDoCliente(pedido3);
		//pedidos.size()
		
	    cliente1.mostraPedidosCliente();
	    
	    cliente2.mostraPedidosCliente();

		
	//	for(int i =0;i<cliente2.pedidos.size();i++)
	//	{
			
	//	System.out.println("| Nome Cliente: " + pedido2.getClientes().get(0).pedidos.get(i).getNumero());
		
	//	}
		
		System.out.println("Pedido  :  " + pedido1.getNumero()+ "| Nome Cliente: " + pedido1.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format( pedido1.getData()) + "| Situacao Pedido :" + " " + pedido1.isStatus()+ "| numero pedido: " + pedido1.getNumero()+ "| pagamento aceito : " + pedido1.isPagamentoAceito() + "| pedido ativo: " + pedido1.isStatus()+ "| detalhe pedido: " + pedido1.adicionaItemPedido(item1));
		
		System.out.println("Pedido  :  " +pedido2.getNumero()+ "| Nome: Cliente " + pedido2.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format( pedido2.getData()) + "| Situacao Pedido :" + " " + pedido2.isStatus()+"| numero pedido: " + pedido2.getNumero() + "| pagamento aceito : " + pedido2.isPagamentoAceito() + "| pedido ativo: " + pedido2.isStatus()+ "| detalhe pedido: " + pedido2.adicionaItemPedido(item2));
		
		System.out.println("Pedido  :  " +pedido3.getNumero()+ "| Nome: Cliente " + pedido3.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format( pedido3.getData()) + "| Situacao Pedido :" + " " + pedido3.isStatus()+"| numero pedido: " + pedido3.getNumero() + "| pagamento aceito : " + pedido3.isPagamentoAceito() + "| pedido ativo: " + pedido3.isStatus()+ "| detalhe pedido: " + pedido3.adicionaItemPedido(item3));
		
		System.out.println(pedido1.calculaTaxa(cliente1));
		
		System.out.println(pedido2.calculaTaxa(cliente2));


	}

}
