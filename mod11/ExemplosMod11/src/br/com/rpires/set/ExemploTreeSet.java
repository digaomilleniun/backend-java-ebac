package br.com.rpires.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Os dados são classificados, mas o acesso é mais lento que em um HashSet.
 * Não repete valores na lista
 *
 * @author rodrigo.pires
 */
public class ExemploTreeSet {

    public static void main(String args[]) {
        exemploListaSimples();
    }

    /**
     * Não repete valores na lista
     * Tem ordem natural dos objetos
     */
    private static void exemploListaSimples() {
        System.out.println("****** exemploListaSimples ******");
        Set<String> lista = new TreeSet<>();
        lista.add("João da Silva");
        lista.add("Antonio Sousa");
        lista.add("Lúcia Ferreira");
        lista.add("João da Silva");
        System.out.println(lista);
        System.out.println("");
    }
}
