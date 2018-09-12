package br.coursera;

public class Principal {

    public static void main(String[] args) {

        
        Calcula calcula = new Calcula();

        calcula.formataCPF("23569879674");
        
        calcula.retornaMaiorNumero(5, 6);
        
        calcula.retornaTemperaturaConvertida(15);
        
        calcula.retornaNumeroAleatorio(1, 4);
    }
}