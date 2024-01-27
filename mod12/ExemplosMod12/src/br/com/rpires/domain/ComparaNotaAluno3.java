package br.com.rpires.domain;

import java.util.Comparator;

public class ComparaNotaAluno3 implements Comparator<Aluno1> {

    @Override
    public int compare(Aluno1 o1, Aluno1 o2) {
        return Double.compare(o2.getNota(), o1.getNota());
    }
}
