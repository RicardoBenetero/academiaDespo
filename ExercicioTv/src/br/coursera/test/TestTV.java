package br.coursera.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.coursera.ControleRemoto;
import br.coursera.TV;

public class TestTV {

	@Test
	public void testLigaTV() {
		
		List<Integer> canais = new ArrayList<Integer>();
		
		for (int i = 0; i >13; i++){
		
		canais.add(i);
		
		}
        
		TV tv = new TV(canais);
		
		ControleRemoto controleRemoto = new ControleRemoto(tv);
		
		controleRemoto.ligaTv();
		

	
		
		asserEquals("ligada",tv.tvEstaLigada());
		
		assert.

	}

}
