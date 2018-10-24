import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		
		List<Jogador> jogadores = new ArrayList<Jogador>();

		Jogador dudu = new Jogador("Dudu", 35);
		Jogador borja = new Jogador("Borja", 25);
		Jogador willian = new Jogador("Willian", 26);
		Jogador lucas = new Jogador("Lucas", 2);
		
		jogadores.add(dudu);
		jogadores.add(borja);
		jogadores.add(willian);
		jogadores.add(lucas);
		
		Collections.sort(jogadores);
		
		for(Jogador jogador: jogadores){
		System.out.println("jogador " +	jogador.getNome() + " quantidade de gols marcados 2018 = " + jogador.getQuantidadeGolsMarcados2018());
		}
		






		
	}

}
