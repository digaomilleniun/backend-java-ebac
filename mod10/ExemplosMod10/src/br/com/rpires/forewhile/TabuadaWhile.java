package br.com.rpires.forewhile;

import java.util.Scanner;

/**
 * @author Steve.Vaz
 */
public class TabuadaWhile {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja gerar a tabuada de algum número? ");
        String resposta = sc.next();

        while(resposta.equalsIgnoreCase("Sim")) {
            System.out.println("Digite um número para gerar a tabuada: ");
            int num = sc.nextInt();
            for (int i = 0; i<=10;i++) {
                System.out.println(num + " X " + i + " = " + num*i);
            }

            System.out.println("Deseja gerar novamente a tabuada de algum número? ");
            resposta = sc.next();
        }

        System.out.println("Obrigado. ");
        
        sc.close();
    }
}
