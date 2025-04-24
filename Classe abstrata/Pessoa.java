
// o método “atualizarID” é declarado abstrato, forçando a declaração da classe como abstrata. Entretanto, o método “recuperarID” é concreto, uma vez que não há necessidade para especializar o comportamento que ele implementa.

//Classe
public abstract class Pessoa {
	//...
	private String identificador;
	//...
	protected abstract boolean atualizarID ( String identificador );
	protected String recuperarID ( ) {
		return this.identificador;
	}
	//...
}

//Apesar de mencionarmos que uma classe abstrata fornece, também, o comportamento comum, isso não é uma obrigação. Nada impede que uma classe abstrata apresente apenas a interface ou apenas a implementação. Aliás, uma classe abstrata pode ter dados de instância e construtores.


//Vejamos o uso da classe abstrata “Pessoa” no seguinte trecho de código:

//Pacotes
package com.mycompany.GereEscola;
//Importações
import java.util.Calendar;
public class Principal {
	//Atributos
	private static Pessoa ref [];
	//Método main
	public static void main (String args[]) {
		ref = new Pessoa [2];
		Calendar data_nasc = Calendar.getInstance();
		Calendar data_criacao = Calendar.getInstance();
		data_nasc.set(1980 , 10 , 23);
		ref [ 0 ] = new Fisica ( "Marco Antônio" , data_nasc , null , null , "Brasil" , "Rio de Janeiro" ); //"365.586.875-45"
		data_criacao.set(1913 , 02 , 01 );
		ref [ 1 ] = new Juridica ( "Escola Novo Mundo Ltda" , data_criacao , null , null , "Brasil" , "Rio de Janeiro" ); //"43.186.666/0026-32"
		ref [ 0 ].atualizarID("365.586.875-45");
		ref [ 1 ].atualizarID("43.186.666/0026-32");
	}
}

//A linha 7 do Código cria um vetor de referências para objetos do tipo “Pessoa”. Nas linhas 14 e 16, são instanciados objetos do tipo “Fisica” e “Juridica”, respectivamente. Esses objetos são referenciados pelo vetor “ref”. Nas linhas 17 e 18, é invocado o método “atualizarID”, que é abstrato na superclasse, mas concreto nas subclasses.

//Assim, o sistema determinará em tempo de execução o objeto, procedendo à vinculação dinâmica do método adequado. Esse é tipicamente um comportamento polimórfico. Na linha 17, o método invocado pertence à classe “Fisica” e na linha 18, à classe “Juridica”.

//Vamos analisar outra hipótese agora. Considere o método “recuperarID” mostrado no Esse método retorna o identificador na forma de uma “String”. Esse comportamento serve tanto para o caso de “Fisica” quanto de “Juridica”. Em verdade, é muito pouco provável que seja necessário especializá-lo, mesmo se, futuramente, uma nova subclasse for adicionada.

//Esse é um dos comportamentos comuns que mencionamos antes e, por isso, ele está na superclasse. Mas se não há motivo para que esse método possa ser rescrito por uma subclasse, é desejável que possamos impedir que isso ocorra inadvertidamente. Felizmente, a linguagem Java fornece um mecanismo para isso. Trata-se do modificador “final”.

//Métodos “final” não podem ser redefinidos nas subclasses. Dessa forma, se tornarmos “recuperarID” “final”, impediremos que ele seja modificado, mesmo por futuras inclusões de subclasses. Esse método permanecerá imutável ao longo de toda a hierarquia de classes. 

//Vimos que, quando aplicados à classe, todos os seus métodos se tornam “final”. Isso quer dizer que nenhum deles poderá ser redefinido. Logo, não faz sentido permitir que essa classe seja estendida, e a linguagem Java proíbe que uma classe “final” possua subclasses. Contudo, ela pode possuir uma superclasse.


//Quando aplicada a uma variável, “final” irá impedir que essa variável seja modificada e exigirá sua inicialização. Esta pode ser feita junto da declaração ou no construtor da classe. Quando inicializada, qualquer tentativa de modificar seu valor gerará erro de compilação.

//Como podemos ver no Código 29, uma classe abstrata pode ter membros “final”. A variável “dias letivos” foi declarada “final” (linha 9) e, por isso, precisa ser inicializada, o que é feito na linha 14, no construtor da classe. A não inicialização dessa variável assim como a tentativa de alterar seu valor gerarão erro em tempo de compilação.

//Pacote
package com.mycompany.GereEscola;
//Importações
public abstract class Auxiliar {
	//Atributos
	private float freq;
	private final int dias_letivos;
	private int presenca;
	//Métodos
	public Auxiliar ( int dias_letivos ) {
		this.dias_letivos = dias_letivos;
	}
	protected final void calcularFrequencia ( ) {
		freq = 100 * ( presenca / dias_letivos );
	}
	protected float recuperarFrequencia ( ) {
		return freq;
	}
	protected abstract float calcularMedia ( );
}