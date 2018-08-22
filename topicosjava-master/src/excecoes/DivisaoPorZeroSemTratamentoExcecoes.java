package excecoes;

import java.util.Scanner;

// Divis�o inteira sem tratamento de exce��es
public class DivisaoPorZeroSemTratamentoExcecoes {

	// Demonstra o lan�amento de uma exce��o quando ocorre uma divis�o por zero
	public static int quociente(int numerador, int denominador) {
		return numerador / denominador; // poss�vel divis�o por zero
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor entre um numerador inteiro: ");
		int numerador = scanner.nextInt();
		System.out.println("Por favor entre um denominador inteiro: ");
		int denominador = scanner.nextInt();

		int resultado = quociente(numerador, denominador);
		System.out.printf("%nResultado: %d / %d = %d", numerador, denominador, resultado);
		scanner.close();
	}

}
