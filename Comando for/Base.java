//Sintaxe:

for ( inicialização ; expressão ; iteração ) {
    bloco;
}

//O parâmetro “inicialização” determina a condição inicial e é executado assim que o laço se inicia. A “expressão” é avaliada em seguida. Se for verdadeira, a repetição ocorre até que se torne falsa. Caso seja falsa no início, o “bloco” não é executado nenhuma vez e a execução do programa saltará para a próxima linha após o laço. O último item, “iteração”, é executado após a execução do “bloco”. No caso de uma “expressão” falsa, o item “iteração” não é executado. Veja um exemplo do uso do comando “for”:


class Base {
    public static void main (String args []) {
        for ( int controle = 0 ; controle < 10 ; controle++ ) {
             System.out.println(controle);
             controle++;
        }
    }
} 

//O Java oferece ainda mais uma possibilidade do comando “for” que é chamada de “for-each”. Esse laço é empregado para iterar sobre uma coleção de objetos, de maneira sequencial. Sendo assim, a sua sintaxe é dada por:

for ( “tipo” “iterador” : “coleção ) {
    bloco;
     }
