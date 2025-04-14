//Classe base para usar mais adiante como referência 

class Alunoo {
    private String nome;
    private int idade;
    public Alunoo ( String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public void definirNome (String nome){
        this.nome = nome;
    }
    public void definirIdade (int idade){
        this.idade = idade;
    }
    public String recuperarNome () {
        return this.nome;
    }
}
