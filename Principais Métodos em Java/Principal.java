//O método “equals” é utilizado para avaliar se outro objeto é igual ao objeto que invoca o método. Se forem iguais, ele retorna “true”; caso contrário, ele retorna “false”. A sua assinatura é “boolean equals (Object obj):

public boolean equals(Object obj) {
	return (this == obj);
}


//Uma aplicação simples de “equals”. O que fazemos é comparar os diversos tipos de objeto utilizando o método “equals”:

public class Principal {
	//Atributos
	private static int I1 , I2 , I3;
	private static String S1 , S2 , S3;
	private static Fisica p1 , p2;
	private static Pessoa p3;

	//Métodos
	public static void main (String args[]) {
		I1 = 1;
		I2 = 2;
		I3 = 1;
		S1 = "a";
		S2 = "b";
		S3 = "a";
		Calendar data_nasc = Calendar.getInstance();
		data_nasc.set(1980, 10, 23);
		p1 = new Fisica ( "Marco Antônio" , data_nasc , "365.586.875-45" , null , "Brasil" , "Rio de Janeiro" );
		p2 = new Fisica ( "Marco Antônio" , data_nasc , "365.586.875-45" , null , "Brasil" , "Rio de Janeiro" );
		p3 = new Pessoa ( "Classe Pessoa" , null , null , null , "Brasil" , "Rio de Janeiro");
		compararEquals ( p1 , p2 , p3 );
		compararEquals ( I1, I2, I3 );
		compararEquals ( S1, S2, S3 );
	}

	private static void compararEquals ( Object o1 , Object o2 , Object o3 ){
		System.out.println("Uso de EQUALS para comparar " + o1.getClass().getName());
			if ( o1.equals( o2 ) )
				System.out.println("o1 == o2");
			else
				System.out.println("o1 != o2");
			if ( o1.equals(o3) )
				System.out.println("o1 == o3");
			else
				System.out.println("o1 != o3");
	}
}

//Com essa especialização, a saída agora é:

Uso de EQUALS para comparar com.mycompany.GereEscola.Fisica
o1 != o2
o1 != o3
Uso de EQUALS para comparar java.lang.Integer
o1 != o2
o1 == o3
Uso de EQUALS para comparar java.lang.String
o1 != o2
o1 == o3


// Precisamos sobrescrever “equals” se quisermos comparar objetos. Mostramos a reimplementação desse método para a classe “Pessoa”:

public boolean equals (Object obj) {
	if ( ( nome.equals( ( ( Pessoa ) obj ).nome ) ) && ( this instanceof Pessoa ) )
		return true;
	else
		return false;
}

//Com essa especialização, a saída agora é:

Uso de EQUALS para comparar com.mycompany.GereEscola.Fisica
o1 == o2
o1 != o3

//Contudo, da forma que implementamos “equals”, “p1” e “p2” serão considerados iguais mesmo que os demais atributos sejam diferentes