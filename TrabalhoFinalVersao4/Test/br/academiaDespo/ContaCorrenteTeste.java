package br.academiaDespo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.academiaDespo.Banco.Conta;
import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;

public class ContaCorrenteTeste implements Conta {

	private String numero;
	private BigDecimal saldo = new BigDecimal("0.0");
	
	private List<String> transacoesEfetuadas = new ArrayList<String>();

	private String insereTransacaoNoExtrato;


	public ContaCorrenteTeste(String numeroConta) {

		this.numero = numeroConta;
	}

	@Override
	public String getNumero() {

		return numero;
	}

	@Override
	public BigDecimal consultarSaldo() {
		return saldo;
	}

	@Override

	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException, ValorInvalidoException{

		insereTransacaoNoExtrato = "operação realizada = realizar deposito: " + valor;

		transacoesEfetuadas.add(insereTransacaoNoExtrato);
		

        if(valor.compareTo(BigDecimal.ZERO) > 0) {


		saldo = saldo.add(valor) ;

       } else {

			throw new ValorInvalidoException("Valor invalido");

        }

	}

	@Override
	public void sacar( BigDecimal valor) {
		
		
		if (saldo.compareTo(valor) > 0 ) {


			saldo = saldo.subtract(valor);
		

			insereTransacaoNoExtrato = "operação realizada = realizar saque: " + valor;

			transacoesEfetuadas.add(insereTransacaoNoExtrato);
		
	}

	
}

	
}
