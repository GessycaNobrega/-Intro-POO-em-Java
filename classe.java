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