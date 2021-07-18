package br.com.rpires.ifelse;

import java.util.Scanner;

/**
 * @author rodrigo.pires
 */
public class ExemploPPT1Console {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número: ");

        int result = s.nextInt();

        if (result == 1) {
            System.out.println("Resultado igual a 1");
        } else if (result > 1) {
            System.out.println("Resultado maior que 1");
        }
        else {
            System.out.println("Resultado menor que 1");
        }
    }
}
