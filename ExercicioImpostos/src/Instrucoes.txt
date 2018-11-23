O objetivo deste exercício é utilizar os conceitos de herança e polimorfismo para calcular o Imposto de Renda de uma coleção de contribuintes, que podem ser pessoas físicas ou pessoas jurídicas.

O cálculo do IR deve ser feito da seguinte maneira:

Pessoa Jurídica
O imposto deve corresponder a 10% da renda bruta da empresa.

Pessoa Física
O imposto deve ser calculado de acordo com a seguinte tabela:

Renda Bruta Alíquota
R$ 0,00 a R$ 2.000,00 0% 
R$ 2.000,01 a R$ 4.000,00 10%
R$ 4.000,01 a R$ 6.000,00 15%
R$ 6.000,01 a R$ 8.000,00 25%
R$ 8.000,01 ou mais 30%


Nos seus testes unitários, você deve ter o seguinte teste, com as adaptações necessárias

@Test
public void calculosImpostoDevemSerCorretos(){
	List<Contribuinte> listaConstribuintes = new ArrayList<>();
	List<Double> resultados = new ArrayList<>();
	
	listaConstribuintes.add(new PessoaFisica("Joao Santos",3000.00,"11111"));
	listaConstribuintes.add(new PessoaJuridica("Lojas AA",150000.00,"10055"));
	listaConstribuintes.add(new PessoaFisica("Maria Soares",5000.00,"22222"));
	listaConstribuintes.add(new PessoaJuridica("Supermercados B",2000000.00,"10066");
	listaConstribuintes.add(new PessoaFisica("Carla Maia",1500.00,"33333");
	listaConstribuintes.add(new PessoaJuridica("Posto XX",500000.00,"10077");
	listaConstribuintes.add(new PessoaFisica("José da Silva",95000.00,"97687");
	
	
	for (Contribuinte contribuinte : listaConstribuintes) {
		resultados.add(contribuinte.calcularImposto());
	}
	
	//Assert de cada resultado
}


Você deve criar classes compatíveis com o teste, que realizem o cálculo corretamente. O teste também deve ser completado com os asserts.

Todo Contribuinte deve ter nome
Apenas Pessoas Físicas devem ter cpf
Apenas Pessoas Jurídicas devem ter cnpj
