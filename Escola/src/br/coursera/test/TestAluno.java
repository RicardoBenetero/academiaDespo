package br.coursera.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.coursera.Aluno;

public class TestAluno {

	@Test
	public void media() {

		Aluno ana = new Aluno();
		ana.bim1 = 70;
		ana.bim2 = 60;
		ana.bim3 = 80;
		ana.bim4 = 70;

		assertEquals(70, ana.media());

	}

	@Test
	public void passouDeAno() {

		Aluno ana = new Aluno();
		ana.bim1 = 70;
		ana.bim2 = 60;
		ana.bim3 = 80;
		ana.bim4 = 70;

		assertEquals(true, ana.passouDeAno());

	}

}
