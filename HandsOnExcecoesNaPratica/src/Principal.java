
public class Principal {

	public static void main(String[] args) throws Exception {

		a(100);
		
		System.out.println("terminando a execucao de main()");


	}

	public static void a(int i)  {
		
		System.out.println("Executando a() com " + i);
		try {

		b(i);
		}catch(Exception e){
			
			System.out.println("tratando a execucao: " + e.getMessage());
			
			
		}
		
		System.out.println("terminando a execucao de a()");


	}

	public static void b(int i) throws Exception {

		System.out.println("Executando b() com " + i);
		if ( i > 0) 
			
		
		
		throw new Exception ("mensagem");
		
		System.out.println("terminando a execucao de b()");


	}

}
