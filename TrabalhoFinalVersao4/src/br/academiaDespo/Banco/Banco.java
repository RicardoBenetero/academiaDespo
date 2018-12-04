package br.academiaDespo.Banco;


	
	import java.math.BigDecimal;
import java.util.List;

import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;

	public interface Banco {
		
		public String getNome();
		
		public List<String> consultarExtrato(String numero);

		public BigDecimal consultarSaldo(String numero) throws ContaInexistenteException;

		public void realizarDeposito(String numero,BigDecimal valor) throws ContaInexistenteException, ValorInvalidoException;

		void sacar(String numeroConta, BigDecimal valor) throws ContaInexistenteException, ValorInvalidoException;

		void realizarTransferencia(String numeroContadeposita, BigDecimal valor, String numeroContaRecebeDeposito)
				throws ContaInexistenteException, ValorInvalidoException;

        
	}


