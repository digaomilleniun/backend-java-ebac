package Exercise_mod23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

public class Genders_list {

	@Test
	public void testFilterWomen() {
		Scanner sc = new Scanner(System.in);
		List<Person> pessoas = new ArrayList<>();

		System.out.print("Enter the number of persons in the list: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Person #" + i + " data:");
			System.out.print("Enter the name: ");
			String name = sc.next();
			System.out.print("Enter the gender of the person (F/M): ");
			char gender = sc.next().charAt(0);
			System.out.print("Enter the nationality: ");
			String nationality = sc.next();

			Person person = new Person(name, gender, nationality);
			pessoas.add(person);
		}

		// Usando Stream e Expressão Lambda para filtrar apenas as mulheres
		List<Person> mulheres = pessoas.stream().filter(pessoa -> pessoa.getGender() == 'F')
				.collect(Collectors.toList());

		// Imprimir o nome, sexo e nacionalidade das mulheres
		mulheres.forEach(pessoa -> System.out.println(
				"\nNome: " 
		        + pessoa.getNome() + ", Sexo: " 
				+ (pessoa.getGender() == 'F' 
				? "Feminino" : "Masculino")
				+ ", Nacionalidade: " + pessoa.getNationality()));

		sc.close();
	}

}
