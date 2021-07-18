package br.com.rpires.switchcase;

import java.util.Scanner;

/**
 * @author rodrigo.pires
 */
public class ExemploAnimal {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o nome de uma animal: ");
        String texto = s.next();
        String animal = exampleOfSwitch(texto);
        System.out.println(animal);
    }

    public static String exampleOfSwitch(String animal) {
        String result;
        switch (animal) {
            case "DOG":
            case "CAT":
                result = "domestic animal";
                break;
            case "TIGER":
                result = "wild animal";
                break;
            default:
                result = "unknown animal";
                break;
        }
        return result;
    }
}
