package br.gov.serpro.bancoBeta;

import java.math.BigDecimal;

public class CalculaTaxa {
	
	 private static BigDecimal TAXA_PORCENTAGEM_SAQUE = new BigDecimal(0.5);
	
     private static BigDecimal TAXA_ACRESCIMO_SAQUE = new BigDecimal(1.0);
     
     private static BigDecimal TAXA_ACRESCIMO_CONSULTA_EXTRATO = new BigDecimal(0.50);
     
     private static BigDecimal TAXA_ACRESCIMO_TRANSFERENCIA = new BigDecimal(1.00);
     
     
     public BigDecimal calculaTaxaDaConsultaExtrato() {
    	 
		return TAXA_ACRESCIMO_CONSULTA_EXTRATO;	 
    	 
     }
     
     
     public BigDecimal calculaTaxaDaTransferencia() {
 		return TAXA_ACRESCIMO_TRANSFERENCIA;
     	 
     	 
     	 
      }
     
     
     
     public BigDecimal calculaTaxaDoSaque(BigDecimal valor) {
    	 
    	 BigDecimal taxaDeSaque = new BigDecimal(0.0);
    	 
    	 BigDecimal valorComTaxa = new BigDecimal(0.0);

    	 
    	 BigDecimal divisor = new BigDecimal(100);

    	 taxaDeSaque = valor.multiply(TAXA_PORCENTAGEM_SAQUE).divide(divisor); 
    	     	 
    	 valorComTaxa =  valor.add(taxaDeSaque);

    	 valorComTaxa = valorComTaxa.add(TAXA_ACRESCIMO_SAQUE);
    	     	     	 
 		return valorComTaxa;
     	 
     	 
     	 
      }


		

}
