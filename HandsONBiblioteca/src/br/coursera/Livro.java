package br.coursera;


public class Livro {
	
	private String codigo;
	private Usuario usuario;
	
	public Livro() {
		
		this.usuario = usuario;
		
	}
	public void anexaUsuarioDoEmprestimo(Usuario usuario) {
		
		this.usuario = usuario;
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
