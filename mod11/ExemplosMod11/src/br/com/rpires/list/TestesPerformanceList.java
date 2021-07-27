package br.com.rpires.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class TestesPerformanceList {
    
    public static void main(String[] args) {
        testeArrayListAdd();
        testeLinkedListAdd();

        testeArrayListRemove();
        testeLinkedListRemove();
    }

    private static void testeLinkedListRemove() {
        final int MAX = 20000;
        long tInicio = System.currentTimeMillis();
        List<Integer> lista = new LinkedList<>();
        for (int i = 0; i < MAX; i++) {
            lista.add(i);
        }

        for (int i = MAX -1; i > 0; i--) {
            lista.remove(i);
        }
        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total LinkedList Remove: " + (tFim - tInicio));
    }

    private static void testeLinkedListAdd() {
        final int MAX = 20000;
        long tInicio = System.currentTimeMillis();
        List<Integer> lista = new LinkedList<>();
        for (int i = 0; i < MAX; i++) {
            lista.add(i);
        }

        for (int i = 0; i < MAX; i++) {
            lista.contains(i);
        }
        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total LinkedList ADD: " + (tFim - tInicio));
    }

    private static void testeArrayListRemove() {
        final int MAX = 20000;
        long tInicio = System.currentTimeMillis();
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < MAX; i++) {
            lista.add(i);
        }

        for (int i = MAX -1; i > 0; i--) {
            lista.remove(i);
        }
        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total ArrayList Remove: " + (tFim - tInicio));
    }

    private static void testeArrayListAdd() {
        final int MAX = 20000;
        long tInicio = System.currentTimeMillis();
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < MAX; i++) {
            lista.add(i);
        }

        for (int i = 0; i < MAX; i++) {
            lista.contains(i);
        }
        long tFim = System.currentTimeMillis();
        System.out.println("Tempo total ArrayList ADD: " + (tFim - tInicio));
    }
}
