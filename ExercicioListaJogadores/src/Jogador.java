import java.util.List;

public class Jogador implements Comparable<Jogador> {

	private String nome;
	private Integer quantidadeGolsMarcados2018;

	public Jogador(String nome, Integer quantidadeGolsMarcados2018) {

		this.nome = nome;
		this.quantidadeGolsMarcados2018 = quantidadeGolsMarcados2018;

	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadeGolsMarcados2018() {
		return quantidadeGolsMarcados2018;
	}

	@Override
	public int compareTo(Jogador outroJogador) {
		if (this.quantidadeGolsMarcados2018 > outroJogador.quantidadeGolsMarcados2018) {
			return -1;
		}
		if (this.quantidadeGolsMarcados2018 < outroJogador.quantidadeGolsMarcados2018) {
			return 1;
		}
		return 0;
	}

}
