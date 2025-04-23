// A sua assinatura é “int hashCode()”, e ele tem como retorno o código hash do objeto.

//A invocação de “hashCode” nos objetos “p1” e “p2” do Código anterior nos dá a seguinte saída:


p1 = 2001049719
p2 = 250421012

//Esse resultado contraria as propriedades de “hashCode”, uma vez que nossa nova implementação de “equals” estabeleceu a igualdade entre “p1” e “p2” instanciados no Código anterior. Para restaurar o comportamento correto, fornecemos a especialização de “hashCode”:

public int hashCode () {
	if ( this instanceof Pessoa )
		return this.nome.hashCode();
	else
		return super.hashCode();
}

//A saída é:

p1 = -456782095
p2 = -456782095