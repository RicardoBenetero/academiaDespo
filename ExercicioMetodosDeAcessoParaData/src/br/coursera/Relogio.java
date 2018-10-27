package br.coursera;

public class Relogio {
private long fixo;
	
	public Relogio(long fixo) {
		
		this.fixo = fixo;
		
	}
	
	

	public long agora() {
		
		if(fixo ==0) {
			return System.currentTimeMillis();
		} else {
			return fixo;
		}
		
	}
}
