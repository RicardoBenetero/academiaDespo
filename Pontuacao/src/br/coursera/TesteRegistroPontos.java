package br.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteRegistroPontos {

	@Test
	public void pontosCriarTopico() {
		
		Usuario usuarioAna = new Usuario();
		usuarioAna.nome = "Ana";
		CalculadoraBonus calculabonus = new CalculadoraBonus();
		RegistroPontos registroPontos = new RegistroPontos(calculabonus);
		registroPontos.criarUmTopico(usuarioAna);
		assertEquals(usuarioAna.pontos,5);
	}
	
	@Test
	public void pontosCriarTopicoVIP() {
		
		Usuario usuarioAna = new Usuario();
		usuarioAna.vip = true;
		usuarioAna.nome = "Ana";
		CalculadoraBonus calculabonus = new CalculadoraBonus();
		RegistroPontos registroPontos = new RegistroPontos(calculabonus);
		registroPontos.criarUmTopico(usuarioAna);
		assertEquals(usuarioAna.pontos,25);
	}
	
	@Test
	public void pontosCriarTopicoBonusDoDia() {
		
		Usuario usuarioAna = new Usuario();
		usuarioAna.nome = "Ana";
		CalculadoraBonus calculabonus = new CalculadoraBonus();
		calculabonus.bonusDoDia = 3;
		RegistroPontos registroPontos = new RegistroPontos(calculabonus);
		registroPontos.criarUmTopico(usuarioAna);
		assertEquals(usuarioAna.pontos,15);
	}
	
	@Test
	public void pontosCriarTopicoVIPBonusDoDia() {
		
		Usuario usuarioAna = new Usuario();
		usuarioAna.nome = "Ana";
		usuarioAna.vip = true;
		CalculadoraBonus calculabonus = new CalculadoraBonus();
		calculabonus.bonusDoDia = 2;
		RegistroPontos registroPontos = new RegistroPontos(calculabonus);
		registroPontos.criarUmTopico(usuarioAna);
		assertEquals(usuarioAna.pontos,50);
	}

}
