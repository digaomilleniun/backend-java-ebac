package br.com.rpires.list;

import br.com.rpires.domain.Aluno1;
import br.com.rpires.domain.ComparaNotaAluno3;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steve.Vaz
 */
public class ExemploLinkedListAluno {

    public static void main(String args[]) {
        exemploListaSimplesOrdenadaComparatorAluno();
        exemploListaSimplesOrdenadaClasseExterna();
    }

    private static void exemploListaSimplesOrdenadaClasseExterna() {
        System.out.println("****** exemploListaSimplesOrdenadaComparatorAluno ******");
        List<Aluno1> lista = new LinkedList<>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        System.out.println(lista);
        //Collections.sort(lista);
        System.out.println(lista);
        System.out.println("");
    }

    private static void exemploListaSimplesOrdenadaComparatorAluno() {
        System.out.println("****** exemploListaSimplesOrdenadaComparatorAluno ******");
        List<Aluno1> lista = new LinkedList<Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 30);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 20);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 10);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        System.out.println("Lista sem ordenação" + lista);
        //Collections.sort(lista);
        System.out.println("Lista com ordenação" + lista);

        ComparaNotaAluno3 comparaNotaAluno = new ComparaNotaAluno3();
        Collections.sort(lista, comparaNotaAluno);
        System.out.println("Lista com ordenação por nota" + lista);

        System.out.println("");
    }
}
