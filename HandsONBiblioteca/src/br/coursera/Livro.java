package br.coursera;


public class Livro {
	
	private String codigo;
	private Usuario usuario;
	boolean emprestado = false;
	String mensagemIndisponivel;
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public String getMensagemIndisponivel() {
		return mensagemIndisponivel;
	}
	public void setMensagemIndisponivel(String mensagemIndisponivel) {
		this.mensagemIndisponivel = mensagemIndisponivel;
	}

}
