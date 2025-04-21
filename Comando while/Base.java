// Comando while

while ( < expressão> ){
    bloco;
}

// O “bloco” será executado apenas se a expressão for verdadeira e, nesse caso, a execução se repete até que a expressão assuma valor falso. No exemplo a seguir, apresentamos um código que imprime os valores de 0 até 9:

//Para obter esse resultado, ele utiliza o valor da variável “controle” para verificar se a condição de teste é válida. Caso seja, ele exibe o valor da variável e, na sequência, incrementa.

class Base {
    public static void main (String args []) {
        private int controle = 0;
        while ( controle < 10 ) {
            System.out.println(controle);
            controle++;
        }
    }
}


//O Java oferece, ainda, a estrutura “do-while”, onde o funcionamento é bem parecido. Porém, ao contrário de “while”, nessa estrutura o bloco sempre será executado ao menos uma vez. Veja sua sintaxe:

do {
    bloco;
} while ( < expressão> );


//Como vemos pela sintaxe, o primeiro “bloco” é executado e, apenas depois disso, a expressão é avaliada. A repetição continua até que a expressão seja falsa. A seguir, veremos um exemplo do comando “do-while”:


class Base {
    public static void main (String args []) {
           private int controle = 0;
           do {
                  System.out.println(controle);
                  controle++;
           }while ( controle < 10 );
    }
} 