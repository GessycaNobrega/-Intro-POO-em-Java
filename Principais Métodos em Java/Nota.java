//Agora vamos explorar algumas situações particulares. Para isso, vamos criar o pacote “Matemática" e, doravante, as classes que temos utilizado (“Principal”, “Pessoa”, “Fisica”, “Juridica”, “Aluno” etc.) estarão inseridas no pacote “GereEscola”.

//No pacote “Matemática", vamos criar a classe “Nota”, que implementa alguns métodos de cálculos relativos às notas dos alunos. Essa classe pode ser parcialmente vista no Código abaixo:

public class Nota {
    //...
        public float calcularMedia () {
                    //...
        }
        protected float calcularCoeficienteRendimento () {
                    //...
        }
    //...
    }
//No pacote “GereEscola”, vamos criar a classe “Desempenho”, conforme mostrado, parcialmente:

//Pacote
package com.mycompany.GereEscola;

//Importações
import com.mycompany.Matematica.Nota;

//Classe
public class Desempenho extends Nota {
	//Atributos
	private float media , CR;
	private Nota nota;

    //Métodos
	public Desempenho () {
		nota = new Nota ();
		media = calcularMedia();
		CR = calcularCoeficienteRendimento();
		//media = nota.calculaMedia();
		//CR = nota.caulculaCoeficienteRendimento();
	}
}

    //A classe “Desempenho” é filha da classe “Nota”. Por isso, ela tem acesso aos métodos “calcularMedia” (público) e “calcularCoeficienteRendimento” (protegido) de “Nota” mesmo estando em outro pacote.


//Observando a linha 11, vemos que ela também possui um objeto do tipo “Nota”, instanciado na linha 15.

//Sendo assim, será que poderíamos comentar as linhas 15 e 16, substituindo-as pelas linhas 18 e 19? A resposta é não.

//Se descomentarmos a linha 18, não haverá problema, mas a linha 19 causará erro de compilação.

//Isso ocorre porque “Desempenho” tem acesso ao método protegido “calcularCoeficienteRendimento” por meio da herança. Por esse motivo, ele pode ser invocado diretamente na classe (linha 17). Mas a invocação feita na linha 19 se dá por meio de uma mensagem enviada para o objeto “nota”, violando a restrição de acesso imposta por “protected” para objetos de pacotes distintos.

//Outra violação de acesso ocorrerá se instanciarmos a classe “Desempenho” em outra parte do pacote “GereEscola” e tentarmos invocar o método “calcularCoeficienteRendimento”, conforme o trecho mostrado no Código 

//Pacote
package com.mycompany.GereEscola;
//...
public class NovaClasse {
	private static Desempenho des;
	//...
	public static void main (String args[]) {
		des = new Desempenho ();
		CR = des. calcularCoeficienteRendimento();
		//...
	}
	//...
}

//Na linha 9, a tentativa de invocar “calcularCoeficienteRendimento” gerará erro de compilação, pois apesar de a classe “Desempenho” ser do mesmo pacote que “NovaClasse”, o método foi recebido por “Desempenho” por meio de herança de superclasse de outro pacote. Logo, como impõe a restrição de acesso protegida, ele não é acessível por classe de outro pacote que não seja uma descendente da superclasse.