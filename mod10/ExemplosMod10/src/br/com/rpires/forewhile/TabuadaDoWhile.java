package br.com.rpires.forewhile;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class TabuadaDoWhile {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String resposta = "";
        do {
            System.out.println("Digite um número para gerar a tabuada: ");
            int num = sc.nextInt();
            for (int i = 0; i<=10;i++) {
                System.out.println(num + " X " + i + " = " + num*i);
            }

            System.out.println("Deseja gerar novamente a tabuada de algum número? ");
            resposta = sc.next();
        } while (resposta.equals("Sim"));

        System.out.println("Obrigado. ");
        
        sc.close();
    }
}
