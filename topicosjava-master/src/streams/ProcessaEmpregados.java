package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessaEmpregados {

	public static void main(String[] args) {
		// Inicializa array de Empregados
		Empregado[] empregados = {
				new Empregado("A�cio", "Neves", 5000, "IT"),
				new Empregado("Tancredo", "Neves", 7600, "IT"),
				new Empregado("Fernando", "Collor", 3587.5, "Vendas"),
				new Empregado("Ciro", "Gomes", 4700.77, "Marketing"),
				new Empregado("Tasso", "Jereissati", 6200, "IT"),
				new Empregado("Camilo", "Santana", 3200, "Vendas"),
				new Empregado("Cid", "Gomes", 4236.4, "Marketing"),
				new Empregado("Cid", "Santana", 4500, "RH")
		};
		
		// obt�m uma lista dos empregados
		List<Empregado> lista = Arrays.asList(empregados);
		
		// exibe todos os empregados
		System.out.println("Lista completa de empregados:");
		lista.stream().forEach(System.out::println);
		
		// Predicado que retorna true para sal�rios na faixa de 4000-6000
		Predicate<Empregado> quatroASeisMil = e -> (e.getSalario() >= 4000 && e.getSalario() <=6000);
		
		// Exibe empregados com sal�rios na faixa de 4000-6000, ordenados em ordem crescente de sal�rio
		System.out.printf("%nEmpregados ganhando de 4000 a 6000 por m�s, ordenados por sal�rio:%n");
		lista.stream()
			.filter(quatroASeisMil)
			.sorted(Comparator.comparing(Empregado::getSalario))
			.forEach(System.out::println);
				
		// Exibe o primeiro empregado com sal�rio na faixa de 4000-6000
		System.out.printf("%nPrimeiro empregado que ganha entre 4000-6000:%n%s%n",
				lista.stream()
					.filter(quatroASeisMil)
					.findFirst()
					.get());
		
		// Fun��es para obter o primeiro e �ltimo nomes de um Empregado
		Function<Empregado, String> primeiroNome = Empregado::getPrimeiroNome;
		Function<Empregado, String> ultimoNome = Empregado::getUltimoNome;
		
		// Comparador para comparar Empregados pelo primeiro nome e depois pelo �ltimo
		Comparator<Empregado> primeiroDepoisUltimo = Comparator.comparing(primeiroNome).thenComparing(ultimoNome);
		
		// Ordena os empregados pelo primeiro nome, e depois pelo �ltimo nome
		System.out.printf("%nEmpregados em ordem ascendente por primeiro nome e depois pelo �ltimo:%n");
		lista.stream()
			.sorted(primeiroDepoisUltimo)
			.forEach(System.out::println);
		
		// ordena os empregados em ordem descendente pelo primeiro nome e depois pelo �ltimo
		System.out.printf("%nEmpregados em ordem descendente por primeiro nome e depois pelo �ltimo:%n");
		lista.stream()
			.sorted(primeiroDepoisUltimo.reversed())
			.forEach(System.out::println);
		
		// Exibe �ltimos nomes �nicos dos empregados em ordem
		System.out.printf("%nLista de nomes �nicos dos empregados:%n");
		lista.stream()
			.map(Empregado::getUltimoNome)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		// Exibe somente o primeiro e �ltimo nomes
		System.out.printf("%nNomes dos empregados em ordem de primeiro nome e depois do �ltimo nome:%n");
		lista.stream()
			.sorted(primeiroDepoisUltimo)
			.map(Empregado::getNome)
			.forEach(System.out::println);
		
		// Agrupa empregados por Departamento
		System.out.printf("%nEmpregados por departamento:%n");
		Map<String, List<Empregado>> agrupadosPorDepartamento =
				lista.stream().collect(Collectors.groupingBy(Empregado::getDepartamento));
		// System.out.println(agrupadosPorDepartamento);
		agrupadosPorDepartamento.forEach(
				(departamento, empregadosNoDepartamento) -> 
				{
					System.out.println(departamento);
					empregadosNoDepartamento.forEach(
							empregado -> System.out.printf("     %s%n", empregado));
				}
		);
		
		// conta o n�mero de empregados em cada departamento
		System.out.printf("%nN�mero de empregados por departamento:%n");
		Map<String, Long> numeroEmpregadosPorDepartamento =
				lista.stream()
					.collect(Collectors.groupingBy(Empregado::getDepartamento, 
							TreeMap::new, Collectors.counting()));
		
		// System.out.println(numeroEmpregadosPorDepartamento);
		numeroEmpregadosPorDepartamento.forEach(
				(departamento, quantidade) -> System.out.printf(
						"%s possui %d empregado(s)%n", departamento, quantidade));
		
		// Soma dos sal�rios dos empregados com DoubleStream sum
		System.out.printf("%nSoma dos sal�rios dos empregados (m�todo sum): %.2f%n",
				lista.stream()
					.mapToDouble(Empregado::getSalario)
					.sum());
		
		// Soma dos sal�rios dos empregados com o m�todo reduce
		System.out.printf("%nSoma dos sal�rios dos empregados (m�todo reduce): %.2f%n",
				lista.stream()
					.mapToDouble(Empregado::getSalario)
					.reduce(0, (valor1, valor2) -> valor1 + valor2));
		
		// M�dia dos sal�rios
		System.out.printf("%nM�dia dos sal�rios dos empregados (m�todo average): %.2f%n",
				lista.stream()
					.mapToDouble(Empregado::getSalario)
					.average()
					.getAsDouble());
		
		
	}

}
