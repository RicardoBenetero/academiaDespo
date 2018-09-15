package br.cousera.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.cousera.Paciente;

public class TestPaciente {

	@Test
	public void testDiagnosticoBaixoPeso() {
		Paciente ana = new Paciente(57, 1.80);
		assertEquals("Baixo peso",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoObesidadeGrauI() {
		Paciente ana = new Paciente(88, 1.65);
		assertEquals("Obesidade grau I",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoSobrepeso() {
		Paciente ana = new Paciente(96, 1.81);
		assertEquals("Sobrepeso",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoPesoNormal() {
		Paciente ana = new Paciente(81, 1.81);
		assertEquals("Peso normal",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoBaixoPesoMuitoGrave() {
		Paciente ana = new Paciente(50, 1.81);
		assertEquals("Baixo peso muito grave",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoBaixoPesoGrave() {
		Paciente ana = new Paciente(55, 1.81);
		assertEquals("Baixo peso grave",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoObesidadeGrauII() {
		Paciente ana = new Paciente(120, 1.81);
		assertEquals("Obesidade grau II",ana.diagnostico());
		
	}
	
	@Test
	public void retornarDiagnosticoObesidadeGrauIII() {
		Paciente ana = new Paciente(150, 1.81);
		assertEquals("Obesidade grau III (obesidade morbida)",ana.diagnostico());
		
	}



}
