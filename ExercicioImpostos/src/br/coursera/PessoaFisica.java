package br.coursera;

public class PessoaFisica implements Contribuinte {

	private String nome;
	private double renda;
	private String cpf;

	public PessoaFisica(String nome, Double renda, String cpf) {

		this.nome = nome;
		this.renda = renda;
		this.cpf = cpf;

	}

	public double calcularImposto() {

		Double resultado = 0.0;

		if (renda == 0.0 || renda <= 2000.0) {

			return resultado;

		} else if (renda > 2000.0 || renda <= 4000.0) {

			return resultado = (renda * 10) / 100;

		} else if (renda > 4000.0 || renda <= 6000.0) {

			return resultado = (renda * 15) / 100;
		} else if (renda > 6000.0 || renda <= 8000.0) {

			return resultado = (renda * 25) / 100;
		} else if (renda > 8000.0) {

			return resultado = (renda * 30) / 100;
		}
		return resultado;

	}

}
