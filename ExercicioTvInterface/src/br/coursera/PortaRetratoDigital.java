package br.coursera;

import java.util.List;

public class PortaRetratoDigital implements Controlavel {

	private static int VOLUME_MAXIMO = 20;
	private static int VOLUME_MINIMO = 0;
	private int volume;
	private List<Integer> musicas;
	private List<Integer> fotos;
	private boolean ligada = false;
	private Integer fotoAtiva = 0;

	public PortaRetratoDigital(List<Integer> musicas,List<Integer> fotos) {

		this.musicas = musicas;
		this.fotos = fotos;


	}

	@Override
	public int aumentaVolume() {
		if (volume < VOLUME_MAXIMO) {
			this.volume++;

		}

		return volume;

	}

	@Override
	public int diminuiVolume() {
		if (volume > VOLUME_MINIMO) {
			this.volume--;

		}

		return volume;

	}

	@Override
	public int avanca() {
		int indiceFotoAtiva = fotos.indexOf(fotoAtiva);

		if (indiceFotoAtiva < fotos.size()-1)// && indiceFotoAtiva != 5)

			fotoAtiva = fotos.get(indiceFotoAtiva + 1);

		return fotoAtiva;

	}

	@Override
	public int retrocede() {
		int indiceFotoAtiva = fotos.indexOf(fotoAtiva);

		if (indiceFotoAtiva <= fotos.size()  && indiceFotoAtiva != 0)

			fotoAtiva = fotos.get(indiceFotoAtiva - 1);

		return fotoAtiva;

	}

	@Override
	public boolean liga() {
		ligada = true;
		return ligada;

	}

	@Override
	public boolean desliga() {
		ligada = false;
		return ligada;

	}

	
	@Override
	public int escolhe(int foto) {
		if (fotos.contains(foto)) {
			fotoAtiva = foto;

		}
		return fotoAtiva;

}
}
