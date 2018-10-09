package br.coursera;

import java.util.HashMap;
import java.util.Map;

public class Corrida {

	private int pista;
	private Map<CarroDeCorrida, Integer> carros = new HashMap<>();

	public Corrida(int tamanho) {

		pista = tamanho;

	}

	public void adiciona(CarroDeCorrida carro) {

		carros.put(carro, 0);

	}

	private boolean terminou() {

		for (Integer valor : carros.values()) {
			if (valor >= pista) {

				return true;
			}

		}
		return false;

	}

	public void umDoisTresEJa() {

		while (!terminou()) {

			for (CarroDeCorrida carro : carros.keySet()) {

				carro.acelerar();

				int distancia = carros.get(carro);

				distancia += carro.getVelocidade();

				carros.put(carro, distancia);

			}
		}

		for (CarroDeCorrida carro : carros.keySet()) {
			System.out.println(carro.getNome() + "  -  " + carros.get(carro));

		}
	}
}
