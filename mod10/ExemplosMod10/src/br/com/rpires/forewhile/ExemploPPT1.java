package br.com.rpires.forewhile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ExemploPPT1 {

    public static void main(String args[]) {
        List<Integer> valores = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {
            System.out.println("Linha " + i);
            valores.add(i);
        }

        for (Integer i : valores) {
            System.out.println("Linha " + i);
        }

        valores.forEach(i-> System.out.println("Linha " + i));

    }
}
