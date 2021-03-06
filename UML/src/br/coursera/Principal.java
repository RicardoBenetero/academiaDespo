package br.coursera;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("24/09/2018");
		// ---------Clientes
		Cliente cliente1 = new Cliente();

		cliente1.setNome("Ana");

		cliente1.setEndereco("Rua Marechal Freitas");

		Cliente cliente2 = new Cliente();

		cliente2.setNome("Joao");

		cliente2.setEndereco("Rua Marechal Freitas");

		// ----itens
		Item item1 = new Item();

		item1.setDescricao("guitarra");

		item1.setPesoEntrega(20);

		item1.setQuantidade(2);

		item1.getPrecoPelaQuantidade(item1.getQuantidade(), "guitarra");

		// ----
		Item item2 = new Item();

		item2.setDescricao("violao");

		item2.setPesoEntrega(15);

		item2.setQuantidade(2);

		item2.getPrecoPelaQuantidade(item2.getQuantidade(), "violao");

		// -----

		Item item3 = new Item();

		item3.setDescricao("violao");

		item3.setPesoEntrega(20);

		item3.setQuantidade(3);

		item3.getPrecoPelaQuantidade(item3.getQuantidade(), "amplificador");

		// ----pedidos
		Pedido pedido1 = new Pedido(cliente1, data, 1, "cheque", 3000);

		Pedido pedido2 = new Pedido(cliente2, data, 3, "dinheiro", 0);

		Pedido pedido3 = new Pedido(cliente2, data, 4, "cartaoCredito", 500);

		pedido1.setData(data);

		formato.format(pedido1.getData());

		pedido1.setStatus(true);

		pedido2.setData(data);

		formato.format(pedido2.getData());

		pedido2.setStatus(true);

		// -----adiciona pedidos para o cliente
		cliente1.adicionaPedidosDoCliente(pedido1);
		cliente2.adicionaPedidosDoCliente(pedido2);
		cliente2.adicionaPedidosDoCliente(pedido3);

		// --- mostra todos pedidos do cliente
		System.out
				.println("---------------------------Mostra Pedidos do Cliente --------------------------------------");
		cliente1.mostraPedidosCliente();

		cliente2.mostraPedidosCliente();
		System.out
				.println("---------------------------Detalhamento Pedidos--------------------------------------------");
		// ----
		System.out.println("Pedido  :  " + pedido1.getNumero() + "| Nome Cliente: "
				+ pedido1.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format(pedido1.getData())
				+ "| Situacao Pedido :" + " " + pedido1.isStatus() + "| numero pedido: " + pedido1.getNumero()
				+ "| pagamento aceito : " + pedido1.isPagamentoAceito() + "| pedido ativo: " + pedido1.isStatus()
				+ "| detalhe pedido: " + pedido1.adicionaItemPedido(item1));

		System.out.println("Pedido  :  " + pedido2.getNumero() + "| Nome: Cliente "
				+ pedido2.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format(pedido2.getData())
				+ "| Situacao Pedido :" + " " + pedido2.isStatus() + "| numero pedido: " + pedido2.getNumero()
				+ "| pagamento aceito : " + pedido2.isPagamentoAceito() + "| pedido ativo: " + pedido2.isStatus()
				+ "| detalhe pedido: " + pedido2.adicionaItemPedido(item2));

		System.out.println("Pedido  :  " + pedido3.getNumero() + "| Nome: Cliente "
				+ pedido3.getClientes().get(0).getNome() + "| Data Pedido: " + formato.format(pedido3.getData())
				+ "| Situacao Pedido :" + " " + pedido3.isStatus() + "| numero pedido: " + pedido3.getNumero()
				+ "| pagamento aceito : " + pedido3.isPagamentoAceito() + "| pedido ativo: " + pedido3.isStatus()
				+ "| detalhe pedido: " + pedido3.adicionaItemPedido(item3));
		System.out.println("--------------------------Taxa  Pedidos--------------------------------------------");
		System.out.println("Pedido 1: " + pedido1.getNumero() + pedido1.calculaTaxa(cliente1));

		System.out.println("Pedido 2: " + pedido2.getNumero() + pedido2.calculaTaxa(cliente2));

		System.out.println("--------------------------Valor Total Pedidos Por Cliente--------------------------------------------");

		System.out.println("Cliente: " + pedido1.getClientes().get(0).getNome() + " Total a pagar ");
		pedido1.calculaTotal();

		System.out.println("Cliente: " + pedido2.getClientes().get(0).getNome() + " Total a pagar ");
		pedido2.calculaTotal();

		System.out.println("--------------------------Peso Total Pedidos Por Cliente-----------------------------------------------------");

		System.out.println("Cliente: " + pedido1.getClientes().get(0).getNome() + " Peso Total Pedidos");
		pedido1.calculaTotalPeso();

		System.out.println("Cliente: " + pedido2.getClientes().get(0).getNome() + " Peso Total Pedidos");
		pedido2.calculaTotalPeso();
		
		System.out.println("--------------------------Quantidade Total Pedidos Da Loja-----------------------------------------------------");

		System.out.println(pedido1.total);
		
		System.out.println("--------------------------Quantidade Valor Total (R$) Pedidos Da Loja-----------------------------------------------------");
		System.out.println("R$"+ pedido1.valorTotal);
		


	}

}
