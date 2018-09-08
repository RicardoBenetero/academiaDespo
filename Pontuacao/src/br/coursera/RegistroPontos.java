package br.coursera;

public class RegistroPontos {
	
	private CalculadoraBonus bonus;
	
	public RegistroPontos(CalculadoraBonus cb){
		this.bonus = cb;
		
		
	}
	
	public void fazerUmComentario(Usuario u){
		u.pontos += 3 * bonus.bonus(u);
		
		
	}
	
	public void criarUmTopico(Usuario u){
		
		u.pontos += 5 * bonus.bonus(u);

		
	}
	
	public void darUmLike(Usuario u){
		u.pontos += 1 * bonus.bonus(u);

		
		
	}



}
