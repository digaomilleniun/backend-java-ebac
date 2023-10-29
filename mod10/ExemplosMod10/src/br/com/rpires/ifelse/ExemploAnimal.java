package br.com.rpires.ifelse;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class ExemploAnimal {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome de uma animal: ");
        String texto = sc.next();
        String animal = exampleOfIF(texto);
        System.out.println(animal);

        sc.close();
    }

    public static String exampleOfIF(String animal) {
        String result;
        if (animal.equals("DOG") || animal.equals("CAT")) {
            result = "domestic animal";
        } else if (animal.equals("TIGER")) {
            result = "wild animal";
        } else {
            result = "unknown animal";
        }
        return result;
    }
}
