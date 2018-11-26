package br.coursera;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestContribuinte {

	@Test
	public void calculosImpostoDevemSerCorretos(){
		List<Contribuinte> listaConstribuintes = new ArrayList<>();
		List<Double> resultados = new ArrayList<>();
		
		listaConstribuintes.add(new PessoaFisica("Joao Santos",3000.00,"11111"));
		listaConstribuintes.add(new PessoaJuridica("Lojas AA",150000.00,"10055"));
		listaConstribuintes.add(new PessoaFisica("Maria Soares",5000.00,"22222"));
		listaConstribuintes.add(new PessoaJuridica("Supermercados B",2000000.00,"10066"));
		listaConstribuintes.add(new PessoaFisica("Carla Maia",1500.00,"33333"));
		listaConstribuintes.add(new PessoaJuridica("Posto XX",500000.00,"10077"));
		listaConstribuintes.add(new PessoaFisica("Jose da Silva",95000.00,"97687"));
		
		
		for (Contribuinte contribuinte : listaConstribuintes) {
			resultados.add(contribuinte.calcularImposto());
		}
		
		//Assert de cada resultado
	}


}
