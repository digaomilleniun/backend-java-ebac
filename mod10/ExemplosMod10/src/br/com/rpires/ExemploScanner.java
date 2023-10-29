package br.com.rpires;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class ExemploScanner {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();
        System.out.println("Vc tem " + idade + " anos.");
        
        sc.close();
    }


}
