/** O código a seguir mostra um exemplo de uma classe em Java: */

public class Aluno {
    private String nome; 
    public void inserirNome(String nn) {
        nome = nn;
    }
    public String recuperarNome() {
        return nome;
    }
    public static void main(String args[]){
        Aluno a = new Aluno(); 
        a.inserirNome ("Pessoa");
        System.out.println("saida: "+a.recuperarNome());
    }
} 

/*há duas formas de declaração de classes: Normal e Enum.

A partir disso, vamos nos deter apenas à forma normal: */

[Modificador] class Identificador [TipoParâmetros] [Superclasse] [Superinterface] { [Corpo da Classe] }

/*um exemplo mais complexo que utiliza mais recursos de declaração de classe em Java: */

@Deprecated @SuppressWarnings ("deprecation") public abstract strictfp class Aluno extends Pai implements Idealizacao, Sonho {
    private String nome; 
    public void inserirNome(String nn){
        nome = nn;
    }
    public String recuperarNome(){
       return nome;
    }
    ...//outros métodos ocultados por simplicidade    
}