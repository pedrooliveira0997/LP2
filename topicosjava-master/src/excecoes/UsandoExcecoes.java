package excecoes;

// Mecanismo de tratamento de exce��es em Java
public class UsandoExcecoes {
	public static void main(String[] args) {
		try {
			lancaExcecao();
		} catch (Exception e) { // exce��o lan�ada por lancaExcecao
			System.err.println("Exce��o tratada no m�todo main");
		}
		naoLancaExcecao();
	}

	public static void lancaExcecao() throws Exception {
		try { // lan�a uma exce��o e a captura imediatamente
			System.out.println("M�todo lancaExcecao");
			throw new Exception(); // gera exce��o
		} catch (Exception e) { // captura a exce��o lan�ada no try
			System.err.println("Exce��o tratada no m�todo lancaExcecao");
			throw e; // relan�a para processamento posterior

			// qualquer c�digo aqui nunca ser� executado, ir� gerar erro de compila��o
		} finally { // executa independente do que ocorra no try...catch
			System.err.println("Finally executado em lancaExcecao");
		}
	}

	private static void naoLancaExcecao() {
		try {   // o bloco try n�o lan�a uma exce��o
			System.out.println("M�todo naoLancaExcecao");
		} catch (Exception e) {    // n�o executa
			System.err.println(e);
		} finally {   // executa independente do que ocorra no try...catch
			System.err.println("Finally executado em naoLancaExcecao");
		}
		System.out.println("Fim do m�todo naoLancaExcecao");
	}
}
