package streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class OperacoesIntStream {

	public static void main(String[] args) {
		// Array original
		int[] valores = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };

		// exibe os valores originais
		System.out.print("Valores originais: ");
		// Consumer - executa uma a��o para cada elemento do stream
		// forEach � uma opera��o terminal
		IntStream.of(valores).forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();

		// count, min, max, sum e average dos valores
		System.out.printf("%nCount: %d%n", IntStream.of(valores).count());
		System.out.printf("Min: %d%n", IntStream.of(valores).min().getAsInt());
		System.out.printf("Max: %d%n", IntStream.of(valores).max().getAsInt());
		System.out.printf("Sum: %d%n", IntStream.of(valores).sum());
		System.out.printf("Average: %.2f%n", IntStream.of(valores).average().getAsDouble());

		// soma dos valores com o m�todo reduce
		System.out.printf("%nSoma usando o m�todo reduce: %d%n", IntStream.of(valores).reduce(0, (x, y) -> x + y));

		// soma dos quadrados dos valores usando reduce
		System.out.printf("%nSoma dos quadrados usando m�todo reduce: %d%n",
				IntStream.of(valores).reduce(0, (x, y) -> x + y * y));

		// produto dos valores usando reduce
		System.out.printf("%nProduto dos valores usando m�todo reduce: %d%n",
				IntStream.of(valores).reduce(1, (x, y) -> x * y));

		// valores pares exibidos em ordem
		System.out.printf("%nValores pares exibidos em ordem: ");
		IntStream.of(valores)
			.filter(valor -> valor % 2 == 0)
			//.map(i -> -i).sorted().map(i -> -i)    // trick para ordenar em ordem descrescente
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();

		// Valores �mpares multiplicados por 10 e exibidos em ordem crescente
		System.out.printf("%nValores �mpares multiplicados por 10 e exibidos em ordem crescente: ");
		IntStream.of(valores)
			.filter(valor -> valor % 2 != 0)
			.map(valor -> valor * 10)
			.sorted()
			.forEach(valor -> System.out.printf("%d ", valor));
		System.out.println();

	}
}
