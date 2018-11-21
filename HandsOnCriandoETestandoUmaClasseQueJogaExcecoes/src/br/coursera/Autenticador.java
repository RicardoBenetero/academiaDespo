package br.coursera;

public class Autenticador {
	
	public Usuario logar(String login, String senha) throws LoginException{
		
		if(login.equals("ricardo") && senha.equals("1234")) {
			
			return new Usuario(login);
		}
		
		
		throw new LoginException("Usuario ou senha invalidos! " , login);
		
		
		
		
	}

}
