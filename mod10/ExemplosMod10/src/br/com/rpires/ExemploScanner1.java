package br.com.rpires;

import java.util.Scanner;

/**
 * @author rodrigo.pires
 */
public class ExemploScanner1 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = s.nextLine();

        System.out.println("\nDigite sua altura: ");
        double altura = s.nextDouble();

        System.out.println(nome + " tem " + altura + " de altura.");
    }
}
