//Sua sintaxe é simples: “op1 instanceof op2”, onde o operando “op2” é o tipo com o qual se deseja comparar; e “op1” é o objeto ou a expressão a ser comparada. 

public class Principal {
    //Atributos
    private static Pessoa p1, p3;
    private static Fisica p2;
    //Métodos
    public static void main (String args[]) {
        Calendar data_nasc = Calendar.getInstance();
        data_nasc.set(1980, 10, 23);
        p1 = new Fisica ( "Marco Antônio" , data_nasc , "365.586.875-45" , null , "Brasil" , "Rio de Janeiro" );
        p2 = new Fisica ( "Marco Antônio" , data_nasc , "365.586.875-45" , null , "Brasil" , "Rio de Janeiro" );
        p3 = new Pessoa ( "Classe Pessoa" , null , null , null , "Brasil" , "Rio de Janeiro");
        if ( p1 instanceof Pessoa )
            System.out.println("p1 é instância do tipo Pessoa.");
        else
            System.out.println("p1 não é instância do tipo Pessoa.");
        if ( p2 instanceof Pessoa )
        System.out.println("p2 é instância do tipo Pessoa.");
        else
            System.out.println("p2 não é instância do tipo Pessoa.");
        if ( p3 instanceof Pessoa )
            System.out.println("p3 é instância do tipo Pessoa.");
        else
            System.out.println("p3 não é instância do tipo Pessoa.");
        if ( p3 instanceof Fisica )
            System.out.println("p3 é instância do tipo Física.");
        else
            System.out.println("p3 não é instância do tipo Física.");
            }
        }

        // 

Nesse código, fazemos quatro comparações, cujos resultados são:

p1 é instância do tipo Pessoa.
p2 é instância do tipo Pessoa.
p3 é instância do tipo Pessoa.
p3 não é instância do tipo Física.