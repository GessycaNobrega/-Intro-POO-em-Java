// O método “toString” permite identificar o objeto retornando uma representação “String” do próprio. Ou seja, trata-se de uma representação textual que assume a forma:

//< nome completamente qualificado da classe à qual o objeto pertence >@ < código hash do objeto >.

//O < nome completamente qualificado da classe à qual o objeto pertence> é a qualificação completa da classe, incluindo o pacote ao qual ela pertence. A qualificação é seguida do símbolo de “@” e, depois dele, do código hash do objeto.


//Veja um exemplo de saída do método “toString”:

com.mycompany.GereEscola.Juridica@72ea2f77

//Nessa saída, notamos o pacote (com.mycompany.GereEscola), a classe (Jurídica) e o hash do objeto (72ea2f77) formando o texto representativo daquela instância.

//A implementação do método “toString” é mostrada no Código abaixo. Nela, identificamos o uso de outros métodos da classe “Object”, como “getClass” e “hashCode”:

//**Essa é a implementação padrão */

public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}

//Vamos modificar o método “toString” para que ele apresente outras informações:

//classe "Pessoa" – código parcial com método "toString" especializado.:

import java.util.Calendar;

public class Pessoa {
	//Atributos
	protected String nome , naturalidade , nacionalidade , identificador;
	private Calendar data_inicio_existencia;
	private int idade;
	private Endereco endereco;

	//Métodos
	public Pessoa ( String nome , Calendar data_inicio_existencia, String identificador , Endereco endereco , String nacionalidade , String naturalidade ) {
		this.nome = nome;
		this.data_inicio_existencia = data_inicio_existencia;
		this.identificador = identificador;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
	}
	//...
	public String toString (){
		return "Objeto:" + "\n\t- Classe: " + getClass().getName() + "\n\t- Hash: " + Integer.toHexString(hashCode()) + "\n\t- Nome: " + nome + "\n\t- Identificador: " + identificador;
	}
}

//classe "Fisica" (derivada de "Pessoa"):

public class Fisica extends Pessoa {
	//Atributos

	//Métodos
	public Fisica ( String nome , Calendar data_nascimento , String CPF , Endereco endereco , String nacionalidade , String naturalidade ) {
		super ( nome , data_nascimento, CPF , endereco , nacionalidade , naturalidade );
	    atualizarIdade ();
	}
}

//O Código abaixo faz a invocação do método “toString” para dois objetos criados, um do tipo “Pessoa” e outro do tipo “Fisica”:

public class Principal {
	private static Pessoa grupo [];
	public static void main (String args[]) {
		grupo = new Pessoa [2];
		grupo [0] = new Fisica ( "Marco Antônio" , data_nasc , “365.586.875-45”, null , "Brasil" , "Rio de Janeiro" );
		grupo [1] = new Pessoa ("Escola Novo Mundo Ltda" , data_nasc , “43.186.666/0026-32” , null , "Brasil" , "Rio de Janeiro");
		for ( int i = 0 ; i <= 1 ; i++ )
			System.out.println( "grupo[" + i + “]: “ + grupo[i].toString() );
	}
}

//A execução do Código acima tem como saída:

grupo[0]: Objeto:
	- Classe: com.mycompany.GereEscola.Fisica
	- Hash: 77459877
	- Nome: Marco Antônio
	- Identificador: 365.586.875-45
grupo[1]: Objeto:
	- Classe: com.mycompany.GereEscola.Pessoa
	- Hash: 378bf509
	- Nome: Escola Novo Mundo Ltda
	- Identificador: 43.186.666/0026-32