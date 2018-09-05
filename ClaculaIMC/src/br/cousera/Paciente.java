package br.cousera;

public class Paciente {
	double peso;
	double altura;

	public Paciente(double peso, double altura) {

		this.peso = peso;
		this.altura = altura;

	}

	public double calcularIMC() {
		return peso / (altura * altura);
	}

	public String diagnostico() {

		double valorImc = calcularIMC();

		if (valorImc < 16) {
			return "Baixo peso muito grave";
		} else if (valorImc >= 16 && valorImc <= 16.99) {
			return "Baixo peso grave";
		} else if (valorImc >= 17 && valorImc <= 18.49) {
			return "Baixo peso ";
		} else if (valorImc >= 18.50 && valorImc <= 24.99) {
			return "Peso normal ";
		} else if (valorImc >= 25 && valorImc <= 29.99) {
			return "Sobrepeso";
		} else if (valorImc >= 30 && valorImc <= 34.99) {
			return "Obesidade grau I ";
		} else if (valorImc >= 35 && valorImc <= 39.99) {
			return "Obesidade grau II ";
		} else {
			return "Obesidade grau III (obesidade morbida)";
		}
	}

}
