package br.com.rpires.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ExemploIterator {

    public static void main(String args[]) {
        List<String> lista = new ArrayList<String>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");

        Iterator<String> it = lista.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
