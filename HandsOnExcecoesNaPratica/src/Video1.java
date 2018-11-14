
public class Video1 {
	
	public double porcao(double valor, double porCento) throws ForaDoIntervaloException {
		
		if (porCento > 100 || porCento < 0) {
			
			throw new ForaDoIntervaloException(String.valueOf(porCento));
		}
		
		return valor * porCento / 100;
	}
	
	
	public static void main(String[] args) {
		
		Video1 video1 = new Video1();
		
		try {
			video1.porcao(1000, -56);
		} catch (ForaDoIntervaloException e) {
			e.printStackTrace();
		}
		
	}

}
