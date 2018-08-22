package generics;

public class MetodoGenerico {

	public static void main(String[] args) {
		// cria arrays de Integer, Double e Character
		Integer[] arrayInteiros = { 1, 2, 3, 4, 5, 6 };
		Double[] arrayDoubles = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] arrayCaracteres = { 'H', 'E', 'L', 'L', 'O' };

		System.out.printf("Array de inteiros cont�m:%n");
		imprimeArray(arrayInteiros); // passa um array de inteiros
		System.out.printf("Array de doubles cont�m:%n");
		imprimeArray(arrayDoubles); // passa um array de doubles
		System.out.printf("Array de caracteres cont�m:%n");
		imprimeArray(arrayCaracteres); // passa um array de caracteres
	}

	// implementa��o gen�rica
	public static <T> void imprimeArray(T[] arrayEntrada) {
		for (T elemento : arrayEntrada)
			System.out.printf("%s ", elemento);
		System.out.println();
	}

}

