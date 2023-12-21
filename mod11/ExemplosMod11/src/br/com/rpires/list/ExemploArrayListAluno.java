package br.com.rpires.list;

import br.com.rpires.domain.Aluno1;
import br.com.rpires.domain.ComparaNotaAluno3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploArrayListAluno {

    public static void main(String args[]) {
        exemploListaSimplesOrdenadaComparatorAluno();
        exemploListaSimplesOrdenadaClasseExterna();
    }

    private static void exemploListaSimplesOrdenadaClasseExterna() {
        System.out.println("****** exemploListaSimplesOrdenadaClasseExterna ******");
        List<Aluno1> lista = new ArrayList<>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        lista.add(a);
        lista.add(b);
        lista.add(c);

        System.out.println("Lista sem ordenação:\n" + lista);
        System.out.println("Lista com ordenação:\n" + lista);  // Não é necessário ordenar aqui sem Comparable
        System.out.println();
    }

    private static void exemploListaSimplesOrdenadaComparatorAluno() {
        System.out.println("****** exemploListaSimplesOrdenadaComparatorAluno ******");
        List<Aluno1> lista = new ArrayList<>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 20);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 30);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 10);
        lista.add(a);
        lista.add(b);
        lista.add(c);

        System.out.println("Lista sem ordenação:\n" + lista);

        Comparator<Aluno1> comparaNotaAluno = new ComparaNotaAluno3();
        Collections.sort(lista, comparaNotaAluno);

        System.out.println("Lista com ordenação por nota:\n" + lista);
        System.out.println();
    }
}
