package br.academiaDespo.Banco;

import java.math.BigDecimal;

import br.academiaDespo.Excecoes.ContaInexistenteException;
import br.academiaDespo.Excecoes.ValorInvalidoException;

public interface Conta {
	
	public String getNumero();
	public BigDecimal consultarSaldo();
	public void realizarDeposito(BigDecimal valor) throws ContaInexistenteException, ValorInvalidoException;
	public void sacar(BigDecimal valor);

}
