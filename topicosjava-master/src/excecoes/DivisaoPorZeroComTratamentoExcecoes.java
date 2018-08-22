package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

// Tratando as exce��es ArithmeticException e InputMismatchException
public class DivisaoPorZeroComTratamentoExcecoes {

	// Demonstra o lan�amento de uma exce��o quando ocorre uma divis�o por zero
	public static int quociente(int numerador, int denominador) throws ArithmeticException {
		return numerador / denominador; // poss�vel divis�o por zero
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuaLoop = true;   // determina se mais entradas s�o necess�rias
		
		do {
			try {   // l� dois n�meros e calcula o quociente
				System.out.println("Por favor entre um numerador inteiro: ");
				int numerador = scanner.nextInt();
				System.out.println("Por favor entre um denominador inteiro: ");
				int denominador = scanner.nextInt();
				int resultado = quociente(numerador, denominador);
				System.out.printf("%nResultado: %d / %d = %d", numerador, denominador, resultado);
				continuaLoop = false;  // entrada bem sucedida, termina o loop
			} catch (InputMismatchException ime) {
				System.err.printf("%nExce��o: %s%n", ime);
				scanner.nextLine();    // descarta a entrada para que o usu�rio possa tentar de novo
				System.out.printf("Voc� deve entrar inteiros. Por favor tente novamente.%n%n");
			}
			catch (ArithmeticException ae) {
				System.err.printf("%nExce��o: %s%n", ae);
				scanner.nextLine();    // descarta a entrada para que o usu�rio possa tentar de novo
				System.out.printf("Zero � um denominador inv�lido. Por favor t100ente novamente.%n%n");
			}
		} while (continuaLoop);
		scanner.close();
	}

}
