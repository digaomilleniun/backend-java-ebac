package br.com.rpires.queue;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ExemploLinkedList {

    public static void main(String args[]) {
        exemploListaSimples();
        exemploListaSimples1();
    }

    private static void exemploListaSimples() {
        System.out.println("****** exemploListaSimples ******");
        Deque<String> lista = new LinkedList<>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        System.out.println(lista);
        System.out.println("");
    }

    private static void exemploListaSimples1() {
        System.out.println("****** exemploListaSimples1 ******");
        Deque<String> lista = new LinkedList<String>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        lista.addFirst("Rodrigo");
        System.out.println(lista);
        System.out.println("");
    }
}
