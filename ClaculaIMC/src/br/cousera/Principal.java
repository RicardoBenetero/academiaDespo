package br.cousera;

public class Principal {

	public static void main(String[] args) {

		Paciente Ana = new Paciente(57,1.80);
		
		Paciente Marcia = new Paciente(88,1.65 );
		
		Paciente Ricardo = new Paciente(96,1.81 );
		
		System.out.println("Índice de massa corporal (IMC) do paciente Ana: " + Ana.diagnostico()+ "\n" );
		System.out.println("Índice de massa corporal (IMC) do paciente Marcia: " + Marcia.diagnostico() + "\n");
		System.out.println("Índice de massa corporal (IMC) do paciente Ricardo: " + Ricardo.diagnostico() + "\n");



	}

}
