package br.academiaDespo.Banco;


	
	import java.math.BigDecimal;
import java.util.List;

import br.academiaDespo.Excecoes.ContaInexistenteException;

	public interface Banco {
		
		public String getNome();
		
		public List<String> consultarExtrato(String numero);

		public BigDecimal consultarSaldo(String numero) throws ContaInexistenteException;

		public void realizarTransferencia(String numeroContadeposita,Double valor, String numeroContaRecebeDeposito) throws ContaInexistenteException;

		public void realizarDeposito(String numero,Double valor) throws ContaInexistenteException;

		public void sacar(String numero,Double valor) throws ContaInexistenteException;

        
	}


