package br.com.rpires.ifelse;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class ExemploPPT1Console {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");

        int result = sc.nextInt();

        if (result == 1) {
            System.out.println("Resultado igual a 1");
        } else if (result > 1) {
            System.out.println("Resultado maior que 1");
        }
        else {
            System.out.println("Resultado menor que 1");
        }
        
        sc.close();
    }
}
