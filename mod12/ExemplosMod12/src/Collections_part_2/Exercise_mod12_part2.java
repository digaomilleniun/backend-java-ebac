package Collections_part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

enum Gender {
    MALE, FEMALE;
}

class Person {
    private int id;
    private String name;
    private double salary;
    private Gender gender;

    public Person(int id, String name, double salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void increaseSalary(double percent) {
        salary += salary * percent / 100.0;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("%.3f%n", salary) + ", " + gender;
    }
}

public class Exercise_mod12_part2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Person #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();

            while (hasId(personList, id)) {
                System.out.println();
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            
            System.out.print("Gender (M/F): ");
            char genderChar = sc.next().charAt(0);
            Gender gender = (genderChar == 'M' || genderChar == 'm') ? Gender.MALE : Gender.FEMALE;

            Person person = new Person(id, name, salary, gender);
            personList.add(person);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        Person emp = personList.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        System.out.println();
        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees: ");
        System.out.println();
        
        for (Person e : personList) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Person> list, int id) {
        for (Person person : list) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }
}