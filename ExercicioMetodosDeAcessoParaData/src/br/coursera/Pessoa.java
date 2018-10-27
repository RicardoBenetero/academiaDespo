package br.coursera;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private LocalDate dataDeNascimento;
	
	public Pessoa(LocalDate dataDeNascimento){
		
		this.dataDeNascimento = dataDeNascimento;
		
	}
	
	
	public int getIdade() {
		
			LocalDate dataInicio = LocalDate.of(dataDeNascimento.getYear(),dataDeNascimento.getMonthValue(),dataDeNascimento.getDayOfMonth());
			LocalDate dataFim = LocalDate.now();		
			Period intervalo = Period.between(dataInicio, dataFim);
			return intervalo.getYears();
		
		
	}
	
	public int mes(){
		
		
		
		return dataDeNascimento.getMonthValue();
		
		
		
		
	}
	
	
	public String getSigno() {
        String signo = "";
		
		switch(dataDeNascimento.getMonthValue()) {
		case 1:
			if(dataDeNascimento.getDayOfMonth()<21) {
				signo = "Capricornio";
			} else {
				signo = "Aquario";
			}
			break;
		case 2:
			if(dataDeNascimento.getDayOfMonth()>=20) {
				signo = "Peixes";
			} else {
				signo = "Aquario";
			}
			break;
		case 3:
			if(dataDeNascimento.getDayOfMonth()>=21) {
				signo = "Aries";
			} else {
				signo = "Peixes";
			}
			break;
		case 4:
			if(dataDeNascimento.getDayOfMonth()>=21) {
				signo = "Touro";
			} else {
				signo = "Aries";
			}
			break;
		case 5:
			if(dataDeNascimento.getDayOfMonth()>=21) {
				signo = "Gemeos";
			} else {
				signo = "Touro";
			}
			break;			
		case 6:
			if(dataDeNascimento.getDayOfMonth()>=21) {
				signo = "Cancer";
			} else {
				signo = "Gemeos";
			}
			break;			
		case 7:
			if(dataDeNascimento.getDayOfMonth()>=22) {
				signo = "Leao";
			} else {
				signo = "Cancer";
			}
			break;			
		case 8:
			if(dataDeNascimento.getDayOfMonth()>=23) {
				signo = "Virgem";
			} else {
				signo = "Leao";
			}
			break;			
		case 9:
			if(dataDeNascimento.getDayOfMonth()>=23) {
				signo = "Libra";
			} else {
				signo = "Virgem";
			}
			break;			
		case 10:
			if(dataDeNascimento.getDayOfMonth()>=23) {
				signo = "Escorpiao";
			} else {
				signo = "Libra";
			}
			break;			
		case 11:
			if(dataDeNascimento.getDayOfMonth()>=22) {
				signo = "Sagitario";
			} else {
				signo = "Escorpiao";
			}
			break;			
		case 12:
			if(dataDeNascimento.getDayOfMonth()>=22) {
				signo = "Capricornio";
			} else {
				signo = "Sagitario";
			}
			break;			
		}
		
		return signo;
		
		
	}
	
	
	

}
