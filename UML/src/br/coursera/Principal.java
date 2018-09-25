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
		
		cliente2.setNome("Ana");
		
		cliente2.setEndereco("Rua Marechal Freitas");
		
	//	List<Cliente>	clientes = new ArrayList<Cliente>();
		
		Pedido pedido1 = new Pedido(cliente1, data, true, 1);
		
		Pedido pedido2 = new Pedido(cliente2, data, true, 1);
		
	   // pedido1 = new Pedido(cliente2);
		
		
		pedido1.setData(data);
	
		formato.format( pedido1.getData());
		
		pedido1.setStatus(true);
		
		
	///	pedido2.setData(data);
	//	
	//	formato.format( pedido2.getData());
		
	//	pedido1.setStatus(true);
	//	
		
	
		

		
		System.out.println("Cliente 1 :  " + " Nome: " + pedido1.getClientes().get(0).getNome() + " Data Pedido: " + formato.format( pedido1.getData()) + " Situacao Pedido :" + " " + pedido1.isStatus() );
		
	//	System.out.println("Cliente 1 :  " + " Nome: " + pedido2.getClientes().get(0).getNome() + " Data Pedido: " + formato.format( pedido2.getData()) + " Situacao Pedido :" + " " + pedido2.isStatus() );
		
	//	System.out.println("Cliente 1 :  " + " Nome: " + pedido1.cliente.getNome() + " Data Pedido: " + formato.format( pedido1.getData()) + " Situacao Pedido :" + " " + pedido1.isStatus() );	

	}

}
