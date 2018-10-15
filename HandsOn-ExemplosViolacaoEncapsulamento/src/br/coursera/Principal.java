package br.coursera;

public class Principal {

	public static void main(String[] args) {

		Pilha p = new Pilha(10);

		p.empilhar("Eduardo");
		p.empilhar("Maria");
		p.empilhar("Jose");
		System.out.println(p.topo());
		System.out.println(p.tamanho());

//desempilhando

		System.out.println("------------------");
		System.out.println(p.desempilhar());
		System.out.println(p.topo());
		System.out.println(p.tamanho());

	}

}
