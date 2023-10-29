package br.com.rpires.switchcase;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class ExemploAnimal {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome de uma animal: ");
        String texto = sc.next();
        String animal = exampleOfSwitch(texto);
        System.out.println(animal);
        
        sc.close();
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
