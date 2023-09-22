package Collections_part_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Exercise_mod12_part1 implements Comparable<Exercise_mod12_part1> {
    private String name;

    public Exercise_mod12_part1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Exercise_mod12_part1 other) {
        // Comparar os nomes em ordem alfabética, ignorando maiúsculas/minúsculas
        return this.name.toLowerCase().compareTo(other.getName().toLowerCase());
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Exercise_mod12_part1> personList = new ArrayList<>();

        System.out.print("How many persons will be registered? ");
        int N = sc.nextInt();
        
        sc.nextLine(); // Consumir a linha em branco após a leitura de N

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Person #" + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            Exercise_mod12_part1 person = new Exercise_mod12_part1(name);
            personList.add(person);
        }

        // Ordenar a lista de pessoas em ordem alfabética (insensível ao caso)
        Collections.sort(personList);

        System.out.println();
        System.out.println("List of persons (sorted alphabetically): ");
        System.out.println();

        for (Exercise_mod12_part1 person : personList) {
        	System.out.println();
            System.out.println(person);
        }

        sc.close();
    }
}
